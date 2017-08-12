package com.qiao.graber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "hello my friend";
    }
}
