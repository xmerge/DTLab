package com.xmerge.DTLab.services.cloud.transitionService.controller;

import com.xmerge.DTLab.services.cloud.transitionService.dto.ManipulationDTO;
import com.xmerge.DTLab.services.cloud.transitionService.service.DataService;
import com.xmerge.framworks.convention.result.Result;
import com.xmerge.services.commonAPI.dto.EndPointDevice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Xmerge
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    private DataService dataService;

    @GetMapping("/getServiceInfo")
    public Result<String> getData(@RequestParam("serverId") String serverId) {
        return dataService.getEdgeServerInfo(serverId);
    }

    @GetMapping("/getServiceInfoAll")
    public Result<Map<String, String>> getDataAll() {
        return dataService.getEdgeServerInfoAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getServerDeviceList")
    public Result<List<EndPointDevice>> getServerDevice(@RequestParam("serverId") String serverId) {
        return dataService.getDeviceList(serverId);
    }

    @GetMapping("/getDeviceInfo")
    public Result<EndPointDevice> getDeviceInfo(@RequestParam("serverId") String serverId, @RequestParam("deviceId") String deviceId) {
        return dataService.getDeviceInfo(serverId, deviceId);
    }

    @PostMapping("/manipulateDeviceStatus")
    public Result<Boolean> manipulateDeviceStatus(@RequestBody ManipulationDTO manipulationDTO) {
        return dataService.manipulateDeviceStatus(manipulationDTO);
    }

    @PostMapping("/manipulateDevices")
    public
    Result<Map<String, String>> manipulateDevices(@RequestBody List<ManipulationDTO> manipulationDTOList) {
        return dataService.manipulateDevices(manipulationDTOList);
    }
}
