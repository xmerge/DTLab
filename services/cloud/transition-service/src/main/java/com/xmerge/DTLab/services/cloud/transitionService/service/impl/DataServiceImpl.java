package com.xmerge.DTLab.services.cloud.transitionService.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xmerge.DTLab.frameworks.web.globalResult.GlobalResult;
import com.xmerge.DTLab.services.cloud.transitionService.dto.ManipulationDTO;
import com.xmerge.DTLab.services.cloud.transitionService.service.DataService;
import com.xmerge.framworks.convention.exception.ServerException;
import com.xmerge.framworks.convention.exception.errorcode.ServerErrorCode;
import com.xmerge.framworks.convention.result.Result;
import com.xmerge.services.commonAPI.dto.EndPointDevice;
import com.xmerge.services.commonAPI.service.EdgeServerService;
import com.xmerge.services.commonAPI.service.ManipulateTCCService;
import com.xmerge.services.commonAPI.service.TestService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.xmerge.DTLab.services.cloud.transitionService.utils.DubboServiceUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xmerge.DTLab.services.cloud.transitionService.utils.DubboServiceUtil.INVOKER_SERVER_MAP;

/**
 * @author Xmerge
 */
@Service
@Slf4j
public class DataServiceImpl implements DataService {

    @Resource
    @Qualifier("testServiceInit")
    private TestService testService;

    @Resource
    @Qualifier("edgeServerServiceInit")
    private EdgeServerService edgeServerService;

    @Resource
    @Qualifier("manipulateTCCServiceInit")
    private ManipulateTCCService manipulateTCCService;

    @Override
    public List<String> getEdgeServerInfoList() {
        return null;
    }


    @Override
    public Result<String> getEdgeServerInfo(String serverId) {
        if (DubboServiceUtil.isServerAvailable(serverId)) {
            RpcContext.getContext().setAttachment("serverId", serverId);
            return GlobalResult.success(edgeServerService.getServerInfo());
        }
        if (DubboServiceUtil.isServerOffline(serverId)) {
            throw new ServerException(ServerErrorCode.SERVER_OFFLINE);
        }
        throw new ServerException(ServerErrorCode.SERVER_NOT_FOUND);
    }

    @Override
    public Result<Map<String, String>> getEdgeServerInfoAll() {
        Map<String, String> res = new HashMap<>();
        for (String key : INVOKER_SERVER_MAP.keySet()) {
            if (DubboServiceUtil.isServerOffline(key)) {
                continue;
            }
            Invoker<?> invoker = INVOKER_SERVER_MAP.get(key).getInvoker();
            String serverId = invoker.getUrl().getParameter("serverId");
            res.put(serverId, getEdgeServerInfo(serverId).getData());
        }
        return GlobalResult.success(res);
    }

    @Override
    public Result<EndPointDevice> getDeviceInfo(String serverId, String deviceId) {
        if (DubboServiceUtil.isServerAvailable(serverId)) {
            RpcContext.getContext().setAttachment("serverId", serverId);
            return GlobalResult.success(edgeServerService.getDeviceInfo(deviceId));
        }
        if (DubboServiceUtil.isServerOffline(serverId)) {
            throw new ServerException(ServerErrorCode.SERVER_OFFLINE);
        }
        throw new ServerException(ServerErrorCode.SERVER_NOT_FOUND);
    }

    @Override
    public Result<List<EndPointDevice>> getDeviceList(String serverId) {
        if (DubboServiceUtil.isServerAvailable(serverId)) {
            RpcContext.getContext().setAttachment("serverId", serverId);
            return GlobalResult.success(edgeServerService.getDeviceList());
        }
        if (DubboServiceUtil.isServerOffline(serverId)) {
            throw new ServerException(ServerErrorCode.SERVER_OFFLINE);
        }
        throw new ServerException(ServerErrorCode.SERVER_NOT_FOUND);
    }

    @Override
    public Result<Boolean> manipulateDeviceStatus(ManipulationDTO manipulationDTO) {
        String serverId = manipulationDTO.getServerId();
        String deviceId = manipulationDTO.getDeviceId();
        String deviceStatus = manipulationDTO.getDeviceStatus();
        if (DubboServiceUtil.isServerAvailable(serverId)) {
            RpcContext.getContext().setAttachment("serverId", serverId);
            return GlobalResult.success(edgeServerService.manipulateDeviceStatus(deviceId, deviceStatus));
        }
        if (DubboServiceUtil.isServerOffline(serverId)) {
            throw new ServerException(ServerErrorCode.SERVER_OFFLINE);
        }
        throw new ServerException(ServerErrorCode.SERVER_NOT_FOUND);
    }

    @Override
    @GlobalTransactional
    public Result<Map<String, String>> manipulateDevices(List<ManipulationDTO> manipulationDTOList) {
        Map<String, String> res = new HashMap<>();
        for (String key : INVOKER_SERVER_MAP.keySet()) {
            Invoker<?> invoker = INVOKER_SERVER_MAP.get(key).getInvoker();
            String serverId = invoker.getUrl().getParameter("serverId");
            if (DubboServiceUtil.isServerOffline(key)) {
                res.put(serverId, "offline");
                continue;
            }
            if (DubboServiceUtil.isServerAvailable(serverId)) {
                RpcContext.getContext().setAttachment("serverId", serverId);
                manipulationDTOList.forEach(manipulationDTO -> {
                    if (manipulationDTO.getServerId().equals(serverId)) {
                        try {
                            boolean rRes = manipulateTCCService.prepare(manipulationDTO.getDeviceId(), manipulationDTO.getDeviceStatus());
                            if (rRes) {
                                res.put(serverId, "success");
                            }
                        } catch (Exception e) {
                            res.put(serverId, "faillll");
                            log.error("manipulateDevices error: {}", e.getMessage());
                            throw new ServerException(e.getMessage());
                        }

                    }
                });
            }
        }
        return GlobalResult.success(res);
    }
}
