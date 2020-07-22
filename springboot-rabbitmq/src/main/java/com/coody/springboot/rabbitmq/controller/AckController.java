package com.coody.springboot.rabbitmq.controller;

import com.coody.springboot.rabbitmq.util.DateUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname AckController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 15:37
 */
@RestController
@RequestMapping("/rabbit")
public class AckController {

    /**
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
     *
     * @return
     */
    @GetMapping("ack1")
    public String messageAck1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("non-existent-exchange", "testDirectRouting", map);
        return "ok";
    }

    /**
     * 2.消息推送到server，找到交换机了，但是没找到队列
     *
     * @return
     */
    @GetMapping("/ack2")
    public String messageAck2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: lonelyDirectExchange test message";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "testDirectRouting", map);
        return "ok";
    }

    /**
     * 3.消息推送到sever，交换机和队列啥都没找到
     *
     * @return
     */
    @GetMapping("ack3")
    public String messageAck3() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: does not exist exchange and queue";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("testExchange", "testRouting", map);
        return "ok";
    }

    /**
     * 4.消息推送成功
     *
     * @return
     */
    @GetMapping("/ack4")
    public String messageAck4() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: send ok";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
        return "ok";
    }
}
