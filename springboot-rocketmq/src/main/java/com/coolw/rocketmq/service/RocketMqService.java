package com.coolw.rocketmq.service;

import com.coolw.rocketmq.dto.MqMessage;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * RocketMQ服务接口
 *
 * @author coolw
 * @date 2022/12/8 8:26
 * @since 1.0
 */
public interface RocketMqService {

    /**
     * 同步发送消息
     * 
     * 场景：当发送的消息很重要是，且对响应时间不敏感的时候采用sync方式
     */
    SendResult syncSend(MqMessage mqMessage);

    /**
     * 异步发送消息,异步返回消息结果 
     * 
     * 场景：当发送的消息很重要，且对响应时间非常敏感的时候采用async方式
     */
    void asynSend(MqMessage mqMessage);
    
    /**
     * 直接发送发送消息，不关心返回结果，容易消息丢失，适合日志收集、不精确统计等消息发送
     * 
     * 场景：当发送的消息不重要时，采用one-way方式，以提高吞吐量
     */
    void syncSendOrderly(MqMessage mqMessage);
}
