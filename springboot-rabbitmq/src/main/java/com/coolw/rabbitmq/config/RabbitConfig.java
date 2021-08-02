package com.coolw.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 生产者推送消息的消息确认 回调函数
 * @Author coolw
 * @Date 2020-02-26 15:28
 */
@Slf4j
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        // 设置开启Mandatory，才能触发回调函数，无论消息推送结果怎么样，都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        /**
         * 确认消息已发送到交换机(exchange)回调函数
         */
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("ConfirmCallback 相关数据:{}", correlationData);
                log.info("ConfirmCallback 确认情况：{}", ack);
                log.info("ConfirmCallback 原因：{}", cause);

                // 业务逻辑处理
            }
        });

        /**
         * 确认消息已发送到队列(queue)回调函数
         */
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("ReturnCallback 消息：{}", message);
                log.info("ReturnCallback 回应码：{}", replyCode);
                log.info("ReturnCallback 回应信息：{}", replyText);
                log.info("ReturnCallback 交换机：{}", exchange);
                log.info("ReturnCallback 路由键：{}", routingKey);

                // 业务逻辑处理
            }
        });

        return rabbitTemplate;
    }
}
