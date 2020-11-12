package com.coolw.interceptor.controller;

import com.coolw.common.api.ResultResponse;
import com.coolw.interceptor.annotation.UnInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname InterceptorController
 * @Description
 * @Author lw
 * @Date 2020-02-25 19:53
 */
@Controller
public class InterceptorController {

    @GetMapping("/interceptor/test")
    public ResultResponse test() {
        return new ResultResponse().success("ok");
    }

    @UnInterceptor
    @GetMapping("/interceptor/test1")
    @ResponseBody
    public ResultResponse test1() {
        return new ResultResponse().success("不被拦截");
    }
}