package com.xmerge.edge.server1;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xmerge
 */
@SpringBootApplication
@EnableDubbo
public class EdgeServer1Application {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(EdgeServer1Application.class, args);
    }
}
