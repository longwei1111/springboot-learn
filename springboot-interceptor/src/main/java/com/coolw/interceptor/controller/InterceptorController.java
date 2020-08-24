package com.coolw.interceptor.controller;

import com.coolw.interceptor.annotation.UnInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname InterceptorController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-25 19:53
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @UnInterceptor
    @GetMapping("/test1")
    @ResponseBody
    public String test1() {
        return "不被拦截";
    }
}