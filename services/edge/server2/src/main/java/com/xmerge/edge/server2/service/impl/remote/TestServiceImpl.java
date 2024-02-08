package com.xmerge.edge.server2.service.impl.remote;

import com.xmerge.services.commonAPI.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Xmerge
 */
@DubboService
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Value("${my.serverId}")
    private String serverId;

    @Override
    public String hello() {
        return "Hello from edge service, serverId: " + serverId;
    }

    @Override
    public String getInfo(String serverId) {
        if (serverId.equals(this.serverId)) {
            return "info: " + serverId;
        }
        return "服务器Id不匹配，当前服务器Id: " + this.serverId + ", 请求服务器Id: " + serverId;
    }
}
