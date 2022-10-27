package com.coolw.aop.controller;

import com.coolw.common.api.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-24 17:44
 */
@Slf4j
@RestController
public class AspectController {

    @GetMapping("/aop/test")
    public BaseResponse test() {
        log.info("===== /aop/test =====");
        return BaseResponse.success();
    }

    @GetMapping("/aop/{name}")
    public BaseResponse testAop(@PathVariable String name) {
        int i = 1/0;
        return BaseResponse.success("Hello " + name);
    }
}
