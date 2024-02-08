package com.xmerge.DTLab.services.cloud.transitionService.service;

import com.xmerge.DTLab.services.cloud.transitionService.dto.ManipulationDTO;
import com.xmerge.framworks.convention.result.Result;
import com.xmerge.services.commonAPI.dto.EndPointDevice;

import java.util.List;
import java.util.Map;

/**
 * @author Xmerge
 */
public interface DataService {

    public List<String> getEdgeServerInfoList();

    public Result<String> getEdgeServerInfo(String serverId);

    public Result<Map<String, String>> getEdgeServerInfoAll();

    public Result<EndPointDevice> getDeviceInfo(String serverId, String deviceId);

    public Result<List<EndPointDevice>> getDeviceList(String serverId);

    public Result<Boolean> manipulateDeviceStatus(ManipulationDTO manipulationDTO);

    public Result<Map<String, String>> manipulateDevices(List<ManipulationDTO> manipulationDTOList);
}
