package com.xmerge.DTLab.services.cloud.transitionService.service.impl;

import com.xmerge.DTLab.frameworks.web.globalResult.GlobalResult;
import com.xmerge.DTLab.services.cloud.transitionService.service.DataService;
import com.xmerge.framworks.convention.exception.ServerException;
import com.xmerge.framworks.convention.exception.errorcode.ServerErrorCode;
import com.xmerge.framworks.convention.result.Result;
import commonAPI.TestService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.xmerge.DTLab.services.cloud.transitionService.utils.DubboServiceUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.xmerge.DTLab.services.cloud.transitionService.utils.DubboServiceUtil.INVOKER_MAP;

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
        if (DubboServiceUtil.isServiceAvailable(serverId)) {
            return GlobalResult.success(testService.getInfo(serverId));
        }
        throw new ServerException(ServerErrorCode.SERVER_NOT_FOUND);
    }

    @Override
    public String getDataAll() {
        List<String> res = new ArrayList<>();
        for (String key : INVOKER_MAP.keySet()) {
            continue;
        }
        return null;
    }
}
