package com.coolw.rabbitmq.consumer.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Classname FanoutConsumerB
 * @Description
 * @Author lw
 * @Date 2020-02-26 15:22
 */
@Slf4j
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutConsumerB {

    @RabbitHandler
    public void process(Map message) {
        log.info("FanoutConsumerB接收到消息，消息={}", message);
    }
}
