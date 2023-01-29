package com.coolw.rocketmq.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * MQ示例:消息消费者
 *
 * @author coolw
 * @date 2022/12/2 16:18
 * @since 1.0
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        // 创建MQ消费者实例,指定消息消费者组名称
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my_test_group");
        consumer.setNamesrvAddr("192.168.110.66:9876");
        // 订阅指定topic下的消息(*代表所有的tag)
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
