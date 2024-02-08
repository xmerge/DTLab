package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import com.xmerge.services.commonAPI.service.EdgeServerService;
import com.xmerge.services.commonAPI.service.ManipulateTCCService;
import com.xmerge.services.commonAPI.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xmerge
 */
@Configuration
@Slf4j
public class DubboServiceConfiguration {

    @DubboReference(loadbalance = "serverId", filter = "serviceFilter", listener = "serviceInvokerListener", check = false)
    private TestService testService;

    @DubboReference(loadbalance = "serverId", filter = "serviceFilter", listener = "serviceInvokerListener", retries = 0, check = false)
    private EdgeServerService edgeServerService;

    @DubboReference(loadbalance = "serverId", filter = "serviceFilter", listener = "serviceInvokerListener", retries = 0, check = false)
    private ManipulateTCCService manipulateTCCService;

    @Bean
    public TestService testServiceInit() {
        return this.testService;
    }

    @Bean
    public EdgeServerService edgeServerServiceInit() {
        return this.edgeServerService;
    }

    @Bean
    public ManipulateTCCService manipulateTCCServiceInit() {
        return this.manipulateTCCService;
    }
}
