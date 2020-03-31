package com.lhj.three.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lhj
 * @Date 2019/10/23 11:06
 * @Description
 */
@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/info")
    public String test(){
        return "get到服务3";
    }
}
