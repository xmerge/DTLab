package com.xmerge.edge.server1.service.impl;

import com.xmerge.edge.server1.service.DeviceService;
import com.xmerge.services.commonAPI.service.ManipulateTCCService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Xmerge
 */
@Slf4j
@Service
@DubboService
public class ManipulateTCCServiceImpl implements ManipulateTCCService {

    @Resource
    DeviceService deviceService;

    @Value("${my.serverId}")
    private String serverId;

    private Boolean committed = false;

    @Override
    public boolean prepare(String deviceId, String deviceStatus) {
        log.info("服务器{} prepare执行了，deviceId:{}, deviceStatus:{}", serverId, deviceId, deviceStatus);
        try {
            throw new RuntimeException("服务器" + serverId + "prepare 执行错误了");
        } catch (Exception e) {
            log.error("服务器{} prepare执行错误了，deviceId:{}, deviceStatus:{}", serverId, deviceId, deviceStatus);
            throw new RuntimeException("服务器" + serverId + "prepare 执行错误了");
        }
//        return false;
    }

    @Override
    public boolean commit(BusinessActionContext param) {
        if (committed) {
            return true;
        }
        log.info("服务器{} commit执行了，deviceId:{}, deviceStatus:{}", serverId, param.getActionContext("deviceId"), param.getActionContext("deviceStatus"));
        committed = true;
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext param) {
        log.info("服务器{} rollback执行了，deviceId:{}, deviceStatus:{}", serverId, param.getActionContext("deviceId"), param.getActionContext("deviceStatus"));
        return true;
    }
}
