package com.coolw.kafka.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.coolw.common.api.Response;
import com.coolw.kafka.dto.Message;
import com.coolw.kafka.dto.UserSyncDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/7/22 13:21
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/sendHello")
    public Response<String> sendHello() {
        String messageIdd = UUID.fastUUID().toString();
        Message<String> message = new Message<>();
        message.setMessageId(messageIdd);
        message.setData("coolw");

        // 默认异步发送
        kafkaTemplate.send("hello-topic", JSONObject.toJSONString(message));
        
        /*ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("hello-topic", "coody");
        // 调用get方法,同步阻塞,可设置等待时间，如果超出，则不再等待结果
        SendResult<String, String> result = future.get(3, TimeUnit.SECONDS);
        log.info("send result:{}", result.getProducerRecord().value());*/

        return new Response<>().success("成功");
    }

    @GetMapping("/sendUser")
    public Response<String> sendUser() {
        UserSyncDTO dto = UserSyncDTO.builder()
                .username("coolw")
                .mobile("15000994425")
                .address("上海市浦东新区xxxxxx")
                .build();
        kafkaTemplate.send("hello-topic", JSONObject.toJSONString(dto));
        return new Response<>().success("成功");
    }
}
