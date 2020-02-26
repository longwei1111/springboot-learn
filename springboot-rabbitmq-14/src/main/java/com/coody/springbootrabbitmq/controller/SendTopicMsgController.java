package com.coody.springbootrabbitmq.controller;

import com.coody.springbootrabbitmq.provider.topic.TopicProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SendTopicMsgController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 14:53
 */
@RestController
@RequestMapping("/topic")
public class SendTopicMsgController {

    @Resource
    TopicProvider topicProvider;

    @GetMapping("/send")
    public String sendTopicMessage(){
        topicProvider.sendTopicMessage();
        return "send ok";
    }

    @GetMapping("/send1")
    public String sendTopicMessage1(){
        topicProvider.sendTopicMessage1();
        return "send1 ok";
    }
}
