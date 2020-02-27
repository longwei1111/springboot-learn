package com.coody.springbootrabbitmq.controller;

import com.coody.springbootrabbitmq.provider.fanout.FanoutProvider;
import com.coody.springbootrabbitmq.provider.topic.TopicProvider;
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
    FanoutProvider fanoutProvider;

    @GetMapping("/send")
    public String sendFanoutMessage(){
        fanoutProvider.sendFanoutMessage();
        return "send ok";
    }
}
