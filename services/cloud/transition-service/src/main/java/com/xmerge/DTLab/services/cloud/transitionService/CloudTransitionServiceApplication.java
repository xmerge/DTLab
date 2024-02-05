package com.xmerge.DTLab.services.cloud.transitionService;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Xmerge
 */
@EnableDubbo
@SpringBootApplication
@ComponentScan(basePackages = {"com.xmerge.DTLab.services.cloud.transitionService", "com.xmerge.DTLab.frameworks.web"})
public class CloudTransitionServiceApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(CloudTransitionServiceApplication.class, args);
    }
}
