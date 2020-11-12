package com.coolw.log4j2.controller;

import com.coolw.common.api.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LogController
 * @Description
 * @Author lw
 * @Date 2020-02-28 08:14
 */
@Slf4j
@RestController
public class LogController {

    /**
     * 常用日志级别从高到低：ERROR > WARN > INFO > DEBUG
     */
    @RequestMapping("/log/print")
    public ResultResponse printLog() {
        log.error("===ERROR 级别日志打印===");
        log.warn("===WARN 级别日志打印===");
        log.info("===INFO 级别日志打印===");
        log.debug("===DEBUG 级别日志打印===");
        return new ResultResponse().success();
    }
}
