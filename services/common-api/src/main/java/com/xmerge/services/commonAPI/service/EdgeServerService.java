package com.xmerge.services.commonAPI.service;

import com.xmerge.services.commonAPI.dto.EndPointDevice;

import java.util.List;

/**
 * @author Xmerge
 */
public interface EdgeServerService {

    public String getEdgeServerId();

    public String getEdgeServerName();

    public String getServerInfo();

    public List<EndPointDevice> getDeviceList();

    public EndPointDevice getDeviceInfo(String deviceId);

    public Boolean manipulateDeviceStatus(String deviceId, String deviceStatus);
}
