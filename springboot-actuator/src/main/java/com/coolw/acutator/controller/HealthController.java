package com.coolw.acutator.controller;

import com.coolw.common.api.ResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HealthController
 * @Description
 * @Date 2021/1/18 16:50
 * @Author lw
 */
@RestController
public class HealthController {

    @GetMapping("/health/test")
    public ResultResponse test() {
        return new ResultResponse().success();
    }
}
