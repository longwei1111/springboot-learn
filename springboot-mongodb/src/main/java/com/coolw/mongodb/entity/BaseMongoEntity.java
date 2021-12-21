package com.coolw.mongodb.entity;

import com.coolw.common.api.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

/**
 * @Description mongodb实体基类
 * @Date 2021/10/12 15:44
 * @Author coolw
 */
@Getter
@Setter
public class BaseMongoEntity extends BaseDomain {

    private static final long serialVersionUID = 5384400110836408273L;

    /** 主键 */
    @Id
    private String id;

    /** 流水号 */
    @Indexed
    private String requestNo;

    /** 请求数据（JSON格式） */
    private String request;

    /** 响应数据（JSON格式） */
    private String response;

    /** 创建时间 */
    @Indexed
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
}
