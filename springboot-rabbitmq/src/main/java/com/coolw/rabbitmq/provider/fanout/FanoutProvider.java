package com.coolw.rabbitmq.provider.fanout;

import com.coolw.rabbitmq.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname FanoutProvider
 * @Description
 * @Author lw
 * @Date 2020-02-26 15:19
 */
@Slf4j
@Component
public class FanoutProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendFanoutMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: testFanoutMessage ";
        String createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createdTime", createdTime);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        log.info("FanoutProvider 消息已发送");
    }
}
