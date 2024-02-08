package com.xmerge.edge.server1.service.impl.remote;

import com.xmerge.edge.server1.service.DeviceService;
import com.xmerge.services.commonAPI.dto.EndPointDevice;
import com.xmerge.services.commonAPI.service.EdgeServerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Xmerge
 */
@DubboService
@Slf4j
@Service
public class EdgeServerServiceImpl implements EdgeServerService {

    @Value("${my.serverId}")
    private String serverId;

    @Resource
    private DeviceService deviceService;

    @Override
    public String getEdgeServerId() {
        return serverId;
    }

    @Override
    public String getEdgeServerName() {
        return serverId;
    }

    @Override
    public String getServerInfo() {
        return serverId;
    }

    @Override
    public List<EndPointDevice> getDeviceList() {
        return deviceService.getDeviceList();
    }

    @Override
    public EndPointDevice getDeviceInfo(String deviceId) {
        return deviceService.getDeviceInfo(deviceId);
    }

    @Override
    public Boolean manipulateDeviceStatus(String deviceId, String deviceStatus) {
        return deviceService.testManipulateDeviceStatusSuccess(deviceId, deviceStatus);
    }
}
