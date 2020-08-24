package com.coolw.rabbitmq.config;

import com.coolw.rabbitmq.consumer.direct.ack.DirectReceiver;
import com.coolw.rabbitmq.config.direct.DirectRabbitConfig;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Classname MessageListenerConfig
 * @Description 消费者接收消息确认配置
 * @Author lw
 * @Date 2020-02-26 16:34
 */
@Configuration
public class MessageListenerConfig {

    @Resource
    private CachingConnectionFactory connectionFactory;

    @Resource
    private DirectReceiver directReceiver;

    @Resource
    private DirectRabbitConfig directRabbitConfig;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        // rabbitmq默认是自动确认，这里改成手动确认
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setQueues(directRabbitConfig.TestDirectQueue());
        container.setMessageListener(directReceiver);
        return container;
    }
}
