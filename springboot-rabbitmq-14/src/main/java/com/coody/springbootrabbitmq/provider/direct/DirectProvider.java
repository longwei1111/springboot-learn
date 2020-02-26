package com.coody.springbootrabbitmq.provider.direct;

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
 * @Classname DirectProvider
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 14:37
 */
@Slf4j
@Component
public class DirectProvider {

    @Resource
    RabbitTemplate rabbitTemplate;

    public void sendDirectMessage() {
        // 消息ID
        String messageId = String.valueOf(UUID.randomUUID());
        // 消息内容
        String messageData = "test message，hello！";
        // 创建时间
        String createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);

        // 将消息绑定键值：testDirectRouting，发送到交换机testDirectExchange
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
        log.info("DirectProvider发送消息成功");
    }


}
