package com.lhj.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author lhj
 * @Date 2019/10/21 14:25
 * @Description
 */
@SpringBootApplication(scanBasePackages = "com.lhj.web")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lhj.web.client")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }
}
