package com.coolw.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * MQ消费者,需实现RocketMQListener类
 *
 * @author coolw
 * @date 2022/12/7 10:22
 * @since 1.0
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "first_topic", consumerGroup = "demo_consumer_group")
public class DemoConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("DemoConsumer message:{}", message);
    }
}
