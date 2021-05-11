package com.coolw.function.exception.controller;

import com.coolw.common.api.ResultResponse;
import com.coolw.function.exception.enums.BusinessMsgEnum;
import com.coolw.function.exception.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ExceptionController
 * @Description
 * @Author lw
 * @Date 2020-02-24 15:37
 */
@Slf4j
@RestController
public class ExceptionController {

    @PostMapping("/exception/test")
    public ResultResponse test(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        log.info("name={}", name);
        log.info("pass={}", pass);
        return new ResultResponse().success();
    }

    @GetMapping("/exception/testNpe")
    public ResultResponse testNullPointerException() {
        String name = null;
        log.info("name长度= {}", name.length());
        return new ResultResponse().success();
    }

    @GetMapping("/exception/business")
    public ResultResponse testBusinessException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new ResultResponse().success();
    }
}
