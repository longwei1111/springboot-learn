package com.coolw.rabbitmq.config.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname DirectRabbitConfig
 * @Description 直连交换器
 * @Author lw
 * @Date 2020-02-26 14:00
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 队列名为testDirectQueue，持久化
     *
     * @return
     */
    @Bean
    public Queue TestDirectQueue() {
        return new Queue("testDirectQueue", true);
    }

    /**
     * 交换机名为testDirectExchange
     *
     * @return
     */
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("testDirectExchange");
    }

    /**
     * 创建一个独立的交换机：lonelyDirectExchange
     *
     * @return
     */
    @Bean
    public DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }

    /**
     * 将队列和交换机绑定，并设置路由键：testDirectRouting
     *
     * @return
     */
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("testDirectRouting");
    }
}
