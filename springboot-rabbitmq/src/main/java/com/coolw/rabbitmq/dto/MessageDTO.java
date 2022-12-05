package com.coolw.rabbitmq.dto;

import cn.hutool.core.util.IdUtil;
import com.coolw.rabbitmq.util.DateUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * 消息DTO
 *
 * @author coolw
 * @date 2022/12/5 8:56
 * @since 1.0
 */
@Data
public class MessageDTO<T> implements Serializable {

    private static final long serialVersionUID = -1216547395109294459L;
    
    private String messageId;
    
    private String createdTime;
    
    private T messageData;
    
    public MessageDTO() {
        this.messageId = IdUtil.fastSimpleUUID();
        this.createdTime = DateUtil.currentDateTime(DateUtil.YYYY_MM_DD_HH_MM_SS);
    }
    
    public MessageDTO(T messageData) {
        this();
        this.messageData = messageData;
    }
}
