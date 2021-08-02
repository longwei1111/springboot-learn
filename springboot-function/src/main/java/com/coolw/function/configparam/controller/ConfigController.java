package com.coolw.function.configparam.controller;

import com.coolw.common.api.Response;
import com.coolw.function.configparam.service.MicroUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-22 18:51
 */
@Slf4j
@RestController
public class ConfigController {

    @Resource
    private MicroUrlService microUrlService;

    @Value("${url.orderUrl}")
    private String orderUrl;

    @RequestMapping("/test/config")
    public Response testConfig() {
        log.info("=====获取的订单服务地址为：{}", orderUrl);
        return new Response().success();
    }

    @RequestMapping("/test/configs")
    public Response testConfigs() {
        log.info("=====获取的订单服务地址为：{}", microUrlService.getOrderUrl());
        log.info("=====获取的用户服务地址为：{}", microUrlService.getUserUrl());
        log.info("=====获取的购物车服务地址为：{}", microUrlService.getShoppingUrl());
        return new Response().success();
    }
}
