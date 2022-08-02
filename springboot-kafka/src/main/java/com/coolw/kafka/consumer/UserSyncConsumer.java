package com.coolw.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import com.coolw.kafka.dto.UserSyncDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 用户信息同步 消费者
 *
 * @author coolw
 * @date 2022/7/22 11:25
 * @since 1.0
 */
@Slf4j
@Component
public class UserSyncConsumer {
    
    @KafkaListener(topics = {"user-topic"})
    public void process(String message) {
        if (StringUtils.isBlank(message)) {
            return;
        }
        UserSyncDTO userSyncDTO = JSONObject.parseObject(message, UserSyncDTO.class);
        log.info("user consumer receive message:{}", userSyncDTO);
    }
}
