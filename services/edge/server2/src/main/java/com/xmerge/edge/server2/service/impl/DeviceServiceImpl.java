package com.xmerge.edge.server2.service.impl;

import com.xmerge.edge.server2.service.DeviceService;
import com.xmerge.services.commonAPI.dto.EndPointDevice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xmerge
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Override
    public List<EndPointDevice> getDeviceList() {
        return new ArrayList<EndPointDevice>(){{
            add(new EndPointDevice("1", "1", 1, "1", 1));
            add(new EndPointDevice("2", "2", 2, "2", 2));
        }};
    }

    @Override
    public EndPointDevice getDeviceInfo(String deviceId) {
        return new EndPointDevice("1", "1", 1, "1", 1);
    }

    @Override
    public Boolean addDevice(EndPointDevice endPointDevice) {
        return true;
    }

    @Override
    public Boolean deleteDevice(String deviceId) {
        return true;
    }

    @Override
    public Boolean updateDevice(EndPointDevice endPointDevice) {
        return true;
    }

    @Override
    public Boolean manipulateDeviceStatus(String deviceId, String deviceStatus) {
        return null;
    }

    @Override
    public Boolean testManipulateDeviceStatusSuccess(String deviceId, String deviceStatus) {
        return true;
    }

    @Override
    public Boolean testManipulateDeviceStatusFalse(String deviceId, String deviceStatus) {
        return false;
    }
}
