package com.coody.springbootrabbitmq.provider.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname FanoutProvider
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 15:19
 */
@Slf4j
@Component
public class FanoutProvider {

    @Resource
    RabbitTemplate rabbitTemplate;

    public void sendFanoutMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: testFanoutMessage ";
        String createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        log.info("FanoutProvider 消息已发送");
    }

}
