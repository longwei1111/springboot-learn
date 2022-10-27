package com.coolw.rabbitmq.controller;

import com.coolw.rabbitmq.provider.topic.TopicProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:53
 */
@RestController
public class SendTopicMsgController {

    @Resource
    private TopicProvider topicProvider;

    @GetMapping("/topic/send")
    public String sendTopicMessage(){
        topicProvider.sendTopicMessageMan();
        return "send ok";
    }

    @GetMapping("/topic/send1")
    public String sendTopicMessage1(){
        topicProvider.sendTopicMessageWoman();
        return "send1 ok";
    }
}
