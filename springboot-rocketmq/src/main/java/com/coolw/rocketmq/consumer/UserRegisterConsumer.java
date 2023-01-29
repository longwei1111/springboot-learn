package com.coolw.rocketmq.consumer;

import com.coolw.rocketmq.constant.MqConstants;
import com.coolw.rocketmq.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册MQ消费者,需实现RocketMQListener类
 *      selectorExpression默认是*,接收topic下的所有消息
 *      
 * @author coolw
 * @date 2022/12/8 8:51
 * @since 1.0
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = MqConstants.USER_TOPIC
        , consumerGroup = MqConstants.USER_CONSUMER_GROUP_REGISTER
        , selectorExpression = MqConstants.USER_TAG_REGISTER)
public class UserRegisterConsumer implements RocketMQListener<UserInfo> {
    
    @Override
    public void onMessage(UserInfo userInfo) {
        log.info("user register userInfo:{}", userInfo);
    }
}
