package com.lhj.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lhj
 * @Date 2019/10/21 11:26
 * @Description
 */
@SpringBootApplication(scanBasePackages = "com.lhj")
@EnableDiscoveryClient
public class ServserApplication {

    public static void main(String[] args){
        SpringApplication.run(ServserApplication.class);
    }
}
