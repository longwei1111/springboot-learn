package com.coolw.kafka.dto;

import com.coolw.common.api.BaseDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * 消息类
 *
 * @author coolw
 * @date 2022/8/2 16:03
 * @since 1.0
 */
@Getter
@Setter
public class Message<T> extends BaseDomain {

    private static final long serialVersionUID = -1212798186425161536L;
    
    private String messageId;
    
    private T data;
}
