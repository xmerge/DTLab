package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import commonAPI.TestService;
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

    @DubboReference(loadbalance = "serverId", filter = "serviceFilter", listener = "serviceInvokerListener")
    private TestService testService;

    @Bean
    public TestService testServiceInit() {
        return this.testService;
    }
}
