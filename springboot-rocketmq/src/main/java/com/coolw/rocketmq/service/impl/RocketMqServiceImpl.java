package com.coolw.rocketmq.service.impl;

import com.coolw.rocketmq.dto.MqMessage;
import com.coolw.rocketmq.service.RocketMqService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * RocketMQ服务接口实现类
 *
 * @author coolw
 * @date 2022/12/8 8:28
 * @since 1.0
 */
@Slf4j
@Service
public class RocketMqServiceImpl implements RocketMqService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public SendResult syncSend(MqMessage mqMessage) {
        log.info("sync send,message:{}", mqMessage);
        String destination = getDestination(mqMessage);
        Message message = MessageBuilder.withPayload(mqMessage.getContent()).build();
        return rocketMQTemplate.syncSend(destination, message);
    }

    @Override
    public void asynSend(MqMessage mqMessage) {
        // 现使用topic+tag来对消息分类;如不需要tag,则将拼接的[冒号和tag属性]去掉,将会接收topic下所有的消息
        String destination = getDestination(mqMessage);
        rocketMQTemplate.asyncSend(destination, mqMessage.getContent()
                , new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        // 消息发送成功处理
                        log.info("asynSend success,message:{}", mqMessage);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        // 消息发送失败处理
                        log.error("asynSend error,message:{},error:{}", mqMessage, throwable.getMessage());
                    }
                });

    }

    @Override
    public void syncSendOrderly(MqMessage mqMessage) {
        log.info("syncSendOrderly,message:{}", mqMessage);
        String destination = getDestination(mqMessage);
        rocketMQTemplate.sendOneWay(destination, mqMessage.getContent());
    }

    private String getDestination(MqMessage mqMessage) {
        String destination = mqMessage.getTopic();
        if (StringUtils.isNotBlank(mqMessage.getTags())) {
            destination += ":" + mqMessage.getTags();
        }
        return destination;
    }
}
