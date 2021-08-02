package com.coolw.rabbitmq.provider.direct;

import com.coolw.rabbitmq.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message，hello！";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        // 将消息绑定键值：testDirectRouting，发送到交换机testDirectExchange
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
        log.info("DirectProvider发送消息成功");
    }
}
