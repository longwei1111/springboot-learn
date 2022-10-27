package com.coolw.rabbitmq.config.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 直连交换器
 * @Author coolw
 * @Date 2020-02-26 14:00
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 队列名为testDirectQueue，持久化
     */
    @Bean
    public Queue testDirectQueue() {
        return new Queue("testDirectQueue", true);
    }

    /**
     * 交换机名为testDirectExchange
     */
    @Bean
    DirectExchange testDirectExchange() {
        return new DirectExchange("testDirectExchange");
    }

    /**
     * 创建一个独立的交换机：lonelyDirectExchange
     */
    @Bean
    public DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }

    /**
     * 将队列和交换机绑定，并设置路由键：testDirectRouting
     */
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("testDirectRouting");
    }
}
