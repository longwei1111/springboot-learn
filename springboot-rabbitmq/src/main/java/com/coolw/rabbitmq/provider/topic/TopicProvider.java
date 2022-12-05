package com.coolw.rabbitmq.provider.topic;

import com.coolw.rabbitmq.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
        String messageData = "message: man";
        MessageDTO<String> messageDTO = new MessageDTO<>(messageData);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", messageDTO);
        log.info("TopicProvider man 发送消息成功");
    }

    public void sendTopicMessageWoman() {
        String messageData = "message: woman is all ";
        MessageDTO<String> messageDTO = new MessageDTO<>(messageData);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", messageDTO);
        log.info("DirectProvider woman 发送消息成功");
    }
}
