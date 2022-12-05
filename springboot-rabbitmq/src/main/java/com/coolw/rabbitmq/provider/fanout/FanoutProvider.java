package com.coolw.rabbitmq.provider.fanout;

import com.coolw.rabbitmq.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 15:19
 */
@Slf4j
@Component
public class FanoutProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendFanoutMessage() {
        String messageData = "message: testFanoutMessage";
        MessageDTO<String> messageDTO = new MessageDTO<>(messageData);
        rabbitTemplate.convertAndSend("fanoutExchange", null, messageDTO);
        log.info("FanoutProvider 消息已发送");
    }
}
