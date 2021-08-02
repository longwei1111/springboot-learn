package com.coolw.rabbitmq.consumer.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 15:00
 */
@Slf4j
@Component
@RabbitListener(queues = "topic.woman")
public class TopicWomanConsumer {

    @RabbitHandler
    public void process(Map messageData) {
        log.info("TopicWomanConsumer接收到消息：{}", messageData.toString());
    }
}
