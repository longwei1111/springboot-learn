package com.coolw.kafka.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.coolw.kafka.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * HELLO消费者
 *
 * @author coolw
 * @date 2022/7/22 11:17
 * @since 1.0
 */
@Slf4j
@Component
public class HelloConsumer {
    
    @KafkaListener(topics={"hello-topic"})
    public void process(ConsumerRecord<?, ?> record) {
        Optional<?> opt = Optional.ofNullable(record.value());
        if (opt.isPresent()) {
            Message<String> message = JSON.parseObject((String) opt.get(), new TypeReference<Message<String>>() {});
            log.info("hello consumer receive messageId:{},data:{}", message.getMessageId(), message.getData());
        }
    }
    
}
