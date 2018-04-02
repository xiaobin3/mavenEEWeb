package com.xiaobin.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * @author : xiaobin3
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/3/30
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

    @RequestMapping("/mvc")
    /**
     * host:8080/hello/mvc
     */
    public String helloMvc(){
        return "home";
    }
}
