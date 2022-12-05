package com.coolw.rocketmq.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/12/2 16:18
 * @since 1.0
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        // 创建MQ消费者实例,并指定名称
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-group");
        consumer.setNamesrvAddr("192.168.110.66:9876");
        // 订阅消费主题
        consumer.subscribe("TopicTest", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}
