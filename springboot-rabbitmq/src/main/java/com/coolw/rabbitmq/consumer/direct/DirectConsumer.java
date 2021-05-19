package com.coolw.rabbitmq.consumer.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:31
 */
@Slf4j
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectConsumer {

    /** 监听的队列名称 testDirectQueue */

    @RabbitHandler
    public void process(Map messageMap) {
        log.info("DirectReceiver接收到消息：{}", messageMap.toString());
    }
}
