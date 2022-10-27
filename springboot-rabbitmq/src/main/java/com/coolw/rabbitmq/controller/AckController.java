package com.coolw.rabbitmq.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.rabbitmq.util.DateUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 15:37
 */
@RestController
public class AckController {

    /*
     * 推送消息四种情况:
     * 1.消息推送到server，但是在server里找不到交换机
     * 2.消息推送到server，找到交换机了，但是没找到队列
     * 3.消息推送到sever，交换机和队列啥都没找到
     * 4.消息推送成功
     */

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 1.消息推送到server，但是在server里找不到交换机
     */
    @GetMapping("/rabbit/ack1")
    public BaseResponse messageAck1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("non-existent-exchange", "testDirectRouting", map);
        return BaseResponse.success();
    }

    /**
     * 2.消息推送到server，找到交换机了，但是没找到队列
     */
    @GetMapping("/rabbit/ack2")
    public BaseResponse messageAck2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: lonelyDirectExchange test message";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "testDirectRouting", map);
        return BaseResponse.success();
    }

    /**
     * 3.消息推送到sever，交换机和队列啥都没找到
     */
    @GetMapping("/rabbit/ack3")
    public BaseResponse messageAck3() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: does not exist exchange and queue";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("testExchange", "testRouting", map);
        return BaseResponse.success();
    }

    /**
     * 4.消息推送成功
     */
    @GetMapping("/rabbit/ack4")
    public BaseResponse messageAck4() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: send ok";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
        return BaseResponse.success();
    }
}
