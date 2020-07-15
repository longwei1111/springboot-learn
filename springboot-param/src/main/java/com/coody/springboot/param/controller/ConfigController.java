package com.coody.springboot.param.controller;

import com.coody.springboot.param.service.MicroUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname ConfigController
 * @Description
 * @Author lw
 * @Date 2020-02-22 18:51
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class ConfigController {

    @Resource
    private MicroUrlService microUrlService;

    @Value("${url.orderUrl}")
    private String orderUrl;

    @RequestMapping("/config")
    public String testConfig() {
        log.info("=====获取的订单服务地址为：{}", orderUrl);
        return "success";
    }

    @RequestMapping("/configs")
    public String testConfigs() {
        log.info("=====获取的订单服务地址为：{}", microUrlService.getOrderUrl());
        log.info("=====获取的用户服务地址为：{}", microUrlService.getUserUrl());
        log.info("=====获取的购物车服务地址为：{}", microUrlService.getShoppingUrl());
        return "success";
    }
}
