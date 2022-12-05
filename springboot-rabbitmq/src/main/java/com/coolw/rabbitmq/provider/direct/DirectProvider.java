package com.coolw.rabbitmq.provider.direct;

import com.coolw.rabbitmq.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:37
 */
@Slf4j
@Component
public class DirectProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendDirectMessage() {
        String messageData = "test message，hello！";
        MessageDTO<String> messageDTO = new MessageDTO<>(messageData);
        // 将消息绑定键值：testDirectRouting，发送到交换机testDirectExchange
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", messageDTO);
        log.info("DirectProvider发送消息成功");
    }
}
