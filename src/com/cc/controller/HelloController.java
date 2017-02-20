package com.cc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 2017/2/15.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return "this is helloController";
    }
}
