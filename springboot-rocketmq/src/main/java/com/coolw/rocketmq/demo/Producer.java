package com.coolw.rocketmq.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * MQ示例:消息生产者
 *
 * @author coolw
 * @date 2022/12/2 16:18
 * @since 1.0
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        // 创建MQ生产者实例,指定消息生产者组名称
        DefaultMQProducer producer = new DefaultMQProducer("my_test_group");
        producer.setNamesrvAddr("192.168.110.66:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("TopicTest", "TagA",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
