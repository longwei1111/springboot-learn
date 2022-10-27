package com.coolw.interceptor.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.interceptor.annotation.UnInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 19:53
 */
@Controller
public class InterceptorController {

    @GetMapping("/interceptor/test")
    public BaseResponse test() {
        return BaseResponse.success("ok");
    }

    @UnInterceptor
    @GetMapping("/interceptor/test1")
    @ResponseBody
    public BaseResponse test1() {
        return BaseResponse.success("不被拦截");
    }
}