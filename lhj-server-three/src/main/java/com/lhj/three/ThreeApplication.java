package com.lhj.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lhj
 * @Date 2019/10/23 11:00
 * @Description
 */
@SpringBootApplication(scanBasePackages = "com.lhj")
@EnableDiscoveryClient
public class ThreeApplication {

    public static void main(String[] args){
        SpringApplication.run(ThreeApplication.class,args);
    }
}
