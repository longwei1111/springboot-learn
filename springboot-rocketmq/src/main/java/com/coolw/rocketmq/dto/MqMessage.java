package com.coolw.rocketmq.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * mq消息定义
 *
 * @author coolw
 * @date 2022/12/8 8:30
 * @since 1.0
 */
@ApiModel("mq消息定义")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MqMessage<T> implements Serializable {

    private static final long serialVersionUID = -1213313967511779436L;
    
    @ApiModelProperty("一级消息,消息topic")
    private String topic;

    @ApiModelProperty("二级消息,消息topic对应的tags")
    private String tags;
    
    @ApiModelProperty("消息内容")
    private T content;
    
    public MqMessage(String topic, String tags) {
        this.topic = topic;
        this.tags = tags;
    }
}
