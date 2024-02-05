package com.xmerge.DTLab.services.cloud.transitionService.controller;

import com.xmerge.DTLab.services.cloud.transitionService.service.DataService;
import com.xmerge.framworks.convention.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Xmerge
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    private DataService dataService;

    @GetMapping("/getData")
    public Result<String> getData(@RequestParam("serverId") String serverId) {
        return dataService.getData(serverId);
    }

    @GetMapping("/getDataAll")
    public Result<Map<String, String>> getDataAll() {
        return dataService.getDataAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
