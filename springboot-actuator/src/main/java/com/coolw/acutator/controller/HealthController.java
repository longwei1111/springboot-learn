package com.coolw.acutator.controller;

import com.coolw.common.api.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/1/18 16:50
 * @Author coolw
 */
@RestController
public class HealthController {

    @GetMapping("/health/test")
    public Response test() {
        return new Response().success();
    }
}
