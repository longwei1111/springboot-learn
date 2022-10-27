package com.coolw.rabbitmq.provider.topic;

import com.coolw.rabbitmq.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:56
 */
@Slf4j
@Component
public class TopicProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendTopicMessageMan() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: man ";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createdTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        log.info("TopicProvider man 发送消息成功");
    }

    public void sendTopicMessageWoman() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all ";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        log.info("DirectProvider woman 发送消息成功");
    }
}
