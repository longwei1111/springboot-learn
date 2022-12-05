package com.coolw.rabbitmq.consumer;

import com.coolw.rabbitmq.dto.MessageDTO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;

/**
 * 消息消费者抽象类
 *
 * @author coolw
 * @date 2022/12/5 16:42
 * @since 1.0
 */
@Slf4j
public abstract class AbstractConsumer<T> {

    /**
     * 消息处理
     */
    protected abstract void process(MessageDTO<T> messageDTO, Channel channel, Message message);

    /**
     * ack确认
     */
    public void ack(MessageDTO<T> messageDTO, Channel channel, Message message) {
        try {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error("messageId:{} ack fail", messageDTO.getMessageId(), e);
        }
    }

    /**
     * nack确认
     */
    public void nack(MessageDTO<T> messageDTO, Channel channel, Message message) {
        // TODO 可以判断重试次数,如果到达了最大重试次数,则放到死信队列中
        try {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicNack(deliveryTag, false, false);
        } catch (Exception e) {
            log.error("messageId:{} nack fail", messageDTO.getMessageId(), e);
        }
    }
}
