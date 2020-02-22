package com.coody.springboot02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-22 18:38
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/log")
    public String testLog() {
        log.debug("=====测试日志debug级别打印=====");
        log.info("=====测试日志debug级别打印=====");
        log.warn("=====测试日志debug级别打印=====");
        log.error("=====测试日志debug级别打印=====");

        return "success";
    }

}
