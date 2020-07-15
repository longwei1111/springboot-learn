package com.coody.springboot.rabbitmq.controller;

import com.coody.springboot.rabbitmq.provider.fanout.FanoutProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SendFanoutMsgController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 14:53
 */
@RestController
@RequestMapping("/fanout")
public class SendFanoutMsgController {

    @Resource
    private FanoutProvider fanoutProvider;

    @GetMapping("/send")
    public String sendFanoutMessage(){
        fanoutProvider.sendFanoutMessage();
        return "send ok";
    }
}
