package com.xmerge.edge.server2;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xmerge
 */
@SpringBootApplication
@EnableDubbo
public class EdgeServer2Application {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(EdgeServer2Application.class, args);
    }
}
