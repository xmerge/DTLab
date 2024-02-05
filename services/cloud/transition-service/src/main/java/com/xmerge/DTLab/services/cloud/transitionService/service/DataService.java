package com.xmerge.DTLab.services.cloud.transitionService.service;

import com.xmerge.framworks.convention.result.Result;

import java.util.List;
import java.util.Map;

/**
 * @author Xmerge
 */
public interface DataService {

    public List<String> getEdgeServerInfoList();

    public String getEdgeServerInfo();

    public Result<String> getData(String serverId);

    public Result<Map<String, String>> getDataAll();
}
