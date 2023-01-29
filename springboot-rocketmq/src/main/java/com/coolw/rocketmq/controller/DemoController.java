package com.coolw.rocketmq.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.rocketmq.dto.MqMessage;
import com.coolw.rocketmq.service.RocketMqService;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/12/8 8:54
 * @since 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private RocketMqService rocketMqService;
    
    @ApiOperation("简单发送消息")
    @PostMapping("/send")
    public BaseResponse send() {
        rocketMQTemplate.convertAndSend("first_topic", "你好,coolw");
        return BaseResponse.success();
    }
    
    @ApiOperation("同步发送消息")
    @PostMapping("/syncSend")
    public BaseResponse syncSend() {
        MqMessage<String> message = new MqMessage<>("first_topic", null);
        message.setContent("你好,coolw......");

        SendResult sendResult = rocketMqService.syncSend(message);
        if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            return BaseResponse.success("消息发送成功");
        } else {
            return BaseResponse.fail("消息发送失败");
        }
    }
}
