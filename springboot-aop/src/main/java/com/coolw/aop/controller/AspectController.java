package com.coolw.aop.controller;

import com.coolw.common.api.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AspectController
 * @Description
 * @Author lw
 * @Date 2020-02-24 17:44
 */
@Slf4j
@RestController
public class AspectController {

    @GetMapping("/aop/test")
    public ResultResponse test() {
        log.info("===== /aop/test =====");
        return new ResultResponse().success();
    }

    @GetMapping("/aop/{name}")
    public ResultResponse testAop(@PathVariable String name) {
        return new ResultResponse().success("Hello " + name);
    }
}
