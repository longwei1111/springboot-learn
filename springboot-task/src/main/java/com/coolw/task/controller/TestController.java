package com.coolw.task.controller;

import com.coolw.task.holder.SpringContextHolder;
import com.coolw.task.service.OrderChannelService;
import com.coolw.task.service.SmsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 * @Description
 * @Date 2021/5/21 16:17
 * @Author coolw
 */
@RestController
public class TestController {

    @Resource
    private ExecutorService orderExecutorService;
    @Resource
    private ExecutorService smsExecutorService;
    @Resource
    private ExecutorService defaultExecutorService;

    @Resource
    private SmsService smsService;

    @PostMapping("/order/create/{channelCode}")
    public String createOrder(@PathVariable String channelCode) {
        OrderChannelService orderChannelService = SpringContextHolder.getBean(channelCode.toLowerCase() + "OrderChannelService");
        orderExecutorService.execute(orderChannelService::createOrder);
        smsExecutorService.execute(orderChannelService::createOrder);
        defaultExecutorService.execute(orderChannelService::createOrder);
        return "ok";
    }

    @PostMapping("/sms/send/{mobileNo}")
    public String smsSend(@PathVariable String mobileNo) {
        defaultExecutorService.execute(() -> smsService.sendSms(mobileNo));
        return "ok";
    }

}
