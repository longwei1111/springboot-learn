package com.coolw.slf4j.controller;

import com.coolw.common.api.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LogController
 * @Description
 * @Author lw
 * @Date 2020-02-22 18:38
 */
@Slf4j
@RestController
public class LogController {

    @RequestMapping("/log/print")
    public ResultResponse testLog() {
        log.debug("=====测试日志DEBUG级别打印=====");
        log.info("=====测试日志INFO级别打印=====");
        log.warn("=====测试日志WARN级别打印=====");
        log.error("=====测试日志ERROR级别打印=====");
        return new ResultResponse().success();
    }
}
