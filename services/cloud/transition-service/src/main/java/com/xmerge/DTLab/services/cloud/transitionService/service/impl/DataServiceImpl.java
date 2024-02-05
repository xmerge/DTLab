package com.xmerge.DTLab.services.cloud.transitionService.service.impl;

import com.xmerge.DTLab.frameworks.web.globalResult.GlobalResult;
import com.xmerge.DTLab.services.cloud.transitionService.service.DataService;
import com.xmerge.framworks.convention.exception.ServerException;
import com.xmerge.framworks.convention.exception.errorcode.ServerErrorCode;
import com.xmerge.framworks.convention.result.Result;
import commonAPI.TestService;

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
public class DataServiceImpl implements DataService {

    @Resource
    @Qualifier("testServiceInit")
    private TestService testService;
    @Override
    public List<String> getEdgeServerInfoList() {
        return null;
    }

    @Override
    public String getEdgeServerInfo() {
        return null;
    }

    @Override
    public Result<String> getData(String serverId) {
        if (DubboServiceUtil.isServerAvailable(serverId)) {
            RpcContext.getContext().setAttachment("serverId", serverId);
            return GlobalResult.success(testService.getInfo(serverId));
        }
        if (DubboServiceUtil.isServerOffline(serverId)) {
            throw new ServerException(ServerErrorCode.SERVER_OFFLINE);
        }
        throw new ServerException(ServerErrorCode.SERVER_NOT_FOUND);
    }

    @Override
    public Result<Map<String, String>> getDataAll() {
        Map<String, String> res = new HashMap<>();
        for (String key : INVOKER_SERVER_MAP.keySet()) {
            if (DubboServiceUtil.isServerOffline(key)) {
                continue;
            }
            Invoker<?> invoker = INVOKER_SERVER_MAP.get(key).getInvoker();
            String serverId = invoker.getUrl().getParameter("serverId");
            res.put(serverId, getData(serverId).getData());
        }
        return GlobalResult.success(res);
    }
}
