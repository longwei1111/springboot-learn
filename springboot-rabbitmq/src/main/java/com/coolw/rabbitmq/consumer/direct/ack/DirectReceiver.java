package com.coolw.rabbitmq.consumer.direct.ack;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 16:41
 */
@Slf4j
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectReceiver implements ChannelAwareMessageListener {
    
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        String messageId = "";
        try {
            // 传递消息用的是map,此处对map数据做些处理
            String msg = message.toString();
            // message中,单引号包含的内容数据就是map消息数据
            String[] msgArray = msg.split("'");
            // 数据转换
            Map<String, String> msgMap = mapStringToMap(msgArray[1]);
            messageId = msgMap.get("messageId");
            String messageData = msgMap.get("messageData");
            String createdTime = msgMap.get("createdTime");
            log.info("===消息手动确认：messageId={},messageData={},createdTime={}", messageId, messageData, createdTime);

            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            // 为true会被重新放回队列
            channel.basicReject(deliveryTag, false);
            log.error("messageId={},消息处理异常", messageId, e);
        }
    }

    /**
     * {key=value,key=value,key=value} 格式转换成 map
     */
    private Map<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0];
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }
}
