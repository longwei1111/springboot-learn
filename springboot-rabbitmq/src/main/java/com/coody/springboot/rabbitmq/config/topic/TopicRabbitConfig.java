package com.coody.springboot.rabbitmq.config.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname TopicRabbitConfig
 * @Description 主题交换机
 * @Author lw
 * @Date 2020-02-26 14:41
 */
@Configuration
public class TopicRabbitConfig {

    // 绑定键
    public static final String MAN = "topic.man";
    public static final String WOMAN = "topic.woman";

    /**
     * 创建队列：topic.man
     *
     * @return
     */
    @Bean
    public Queue manQueue() {
        return new Queue(MAN);
    }

    /**
     * 创建队列：topic.woman
     *
     * @return
     */
    @Bean
    public Queue womenQueue() {
        return new Queue(WOMAN);
    }

    /**
     * 设置topic交换机名：topicExchange
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将队列topic.man和交换机topicExchange绑定，路由键规则为topic.#
     * 消息携带的路由键是以topic.man,才会分发到该队列
     *
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(manQueue()).to(topicExchange()).with(MAN);
    }

    /**
     * 将队列topic.woman和交换机topicExchange绑定，路由键规则为topic.#
     * 息携带的路由键是以topic.开头，都会分发到该队列
     *
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(womenQueue()).to(topicExchange()).with("topic.#");
    }
}
