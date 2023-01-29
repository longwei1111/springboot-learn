package com.coolw.rocketmq.constant;

/**
 * 消息队列相关常量定义
 *
 * @author coolw
 * @date 2022/12/8 9:02
 * @since 1.0
 */
public final class MqConstants {

    /** 用户消息topic */
    public static final String USER_TOPIC = "user_topic";
    
    /** 用户修改tag */
    public static final String USER_TAG_MODIFY = "modify";

    /** 用户注册tag */
    public static final String USER_TAG_REGISTER = "register";
    
    /** 用户注册消费者组 */
    public static final String USER_CONSUMER_GROUP_REGISTER = "user_consumer_group_register";

    /** 用户修改消费者组 */
    public static final String USER_CONSUMER_GROUP_MODIFY = "user_consumer_group_modify";
}
