package com.coolw.rabbitmq.consumer.direct;

import com.coolw.rabbitmq.consumer.AbstractConsumer;
import com.coolw.rabbitmq.dto.MessageDTO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:31
 */
@Slf4j
@Component
public class DirectConsumer extends AbstractConsumer<String> {

    @Override
    @RabbitListener(queues = "testDirectQueue")
    public void process(MessageDTO<String> messageDTO, Channel channel, Message message) {
        log.info("DirectReceiver接收到消息:{}", messageDTO);
        try {
            ack(messageDTO, channel, message);
        } catch (Exception e) {
            log.error("DirectReceiver消费者处理消息异常messageId:{}", messageDTO.getMessageId(), e);
            nack(messageDTO, channel, message);
        }
    }
}
