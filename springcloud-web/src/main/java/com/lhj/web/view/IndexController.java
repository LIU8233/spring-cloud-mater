package com.lhj.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lhj
 * @Date 2019/10/25 10:10
 * @Description
 */
@Controller
public class IndexController {

    @RequestMapping("/myLogin")
    public String login(){
        return "thymeleaf/home";
    }
}
