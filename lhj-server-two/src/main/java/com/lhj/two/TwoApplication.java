package com.lhj.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lhj
 * @Date 2019/10/23 10:54
 * @Description
 */
@SpringBootApplication(scanBasePackages = "com.lhj")
@EnableDiscoveryClient
public class TwoApplication {

    public static void main(String[] args){
        SpringApplication.run(TwoApplication.class,args);
    }
}
