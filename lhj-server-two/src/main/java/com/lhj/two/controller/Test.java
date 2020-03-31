package com.lhj.two.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lhj
 * @Date 2019/10/23 10:58
 * @Description
 */
@RestController
@RequestMapping("/test2")
public class Test {

    @GetMapping("/info")
    public String test(){
        return "get到服务2";
    }
}
