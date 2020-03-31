package com.lhj.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lhj
 * @Date 2019/10/23 10:45
 * @Description
 */
@SpringBootApplication(scanBasePackages = "com.lhj")
@EnableDiscoveryClient
public class OneApplication {

    public static void main(String[] args){
        SpringApplication.run(OneApplication.class,args);
    }
}
