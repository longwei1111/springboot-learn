package com.coody.springbootrabbitmq.provider.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname TopicProvider
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 14:56
 */
@Slf4j
@Component
public class TopicProvider {

    @Resource
    RabbitTemplate rabbitTemplate;

    public void sendTopicMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        log.info("TopicProvider man 发送消息成功");
    }

    public void sendTopicMessage1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all ";
        String createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        log.info("DirectProvider woman 发送消息成功");
    }
}
