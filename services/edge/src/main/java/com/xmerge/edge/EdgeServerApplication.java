package com.xmerge.edge;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xmerge
 */
@SpringBootApplication
@EnableDubbo
public class EdgeServerApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(EdgeServerApplication.class, args);
    }
}
