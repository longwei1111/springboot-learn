package com.coolw.rabbitmq.controller;

import com.coolw.rabbitmq.provider.fanout.FanoutProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:53
 */
@RestController
public class SendFanoutMsgController {

    @Resource
    private FanoutProvider fanoutProvider;

    @GetMapping("/fanout/send")
    public String sendFanoutMessage(){
        fanoutProvider.sendFanoutMessage();
        return "send ok";
    }
}
