package com.xmerge.edge.server2.service;

import com.xmerge.services.commonAPI.dto.EndPointDevice;

import java.util.List;

/**
 * @author Xmerge
 */
public interface DeviceService {

    public List<EndPointDevice> getDeviceList();

    public EndPointDevice getDeviceInfo(String deviceId);

    public Boolean addDevice(EndPointDevice endPointDevice);

    public Boolean deleteDevice(String deviceId);

    public Boolean updateDevice(EndPointDevice endPointDevice);

    public Boolean manipulateDeviceStatus(String deviceId, String deviceStatus);

    public Boolean testManipulateDeviceStatusSuccess(String deviceId, String deviceStatus);

    public Boolean testManipulateDeviceStatusFalse(String deviceId, String deviceStatus);
}
