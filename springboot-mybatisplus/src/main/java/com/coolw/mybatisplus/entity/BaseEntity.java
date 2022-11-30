package com.coolw.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.coolw.common.api.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/7/1 15:40
 * @since 1.0
 */
public class BaseEntity extends BaseDomain {

    private static final long serialVersionUID = -5229728218822933724L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    private Date updateTime;
}
