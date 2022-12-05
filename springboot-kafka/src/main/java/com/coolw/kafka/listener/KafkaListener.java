package com.coolw.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;

import javax.annotation.PostConstruct;

/**
 * kafka 监听生产者异步发送消息
 *
 * @author coolw
 * @date 2022/8/2 16:24
 * @since 1.0
 */
@Slf4j
@Configuration
public class KafkaListener {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostConstruct
    public void listener() {
        kafkaTemplate.setProducerListener(new ProducerListener<String, Object>() {

            @Override
            public void onSuccess(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
                log.info("success==>message:{}", producerRecord.value());
            }

            @Override
            public void onError(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata, Exception exception) {
                log.error("error==>message:{}", producerRecord.value(), exception);
            }
            
            /*@Override
            public void onError(ProducerRecord<String, Object> producerRecord, Exception e) {
                log.error("error==>message:{}", producerRecord.value(), e);
            }*/
        });
    }
}
