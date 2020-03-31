package com.lhj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author lhj
 * @Date 2019/10/21 10:24
 * @Description
 */
@SpringBootApplication
@EnableZuulProxy
//@EnableFeignClients
public class GatewayApplication {

    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }
}
