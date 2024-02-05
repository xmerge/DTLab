package com.xmerge.DTLab.frameworks.web.config;

import com.xmerge.DTLab.frameworks.web.globalException.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Xmerge
 */
@Slf4j
public class WebAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler() {
        log.info("GlobalExceptionHandler初始化了");
        return new GlobalExceptionHandler();
    }
}
