package com.coody.springboot.log4j2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname Log4j2Controller
 * @Description TODO
 * @Author lw
 * @Date 2020-02-28 08:14
 */
@Slf4j
@RestController
@RequestMapping("/log4j2")
public class Log4j2Controller {

    /**
     * 常用日志级别从高到低：ERROR > WARN > INFO > DEBUG
     *
     * @return
     */
    @RequestMapping("/print")
    public String printLog() {
        log.error("===ERROR 级别日志打印===");
        log.warn("===WARN 级别日志打印===");
        log.info("===INFO 级别日志打印===");
        log.debug("===DEBUG 级别日志打印===");
        return "success";
    }
}
