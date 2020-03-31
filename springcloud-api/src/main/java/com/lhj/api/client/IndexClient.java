package com.lhj.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author lhj
 * @Date 2019/10/21 17:53
 * @Description
 */
@Component
@FeignClient(name = "springcloud-producer")
public interface IndexClient {

    @GetMapping("/index/test")
    public String test();
}
