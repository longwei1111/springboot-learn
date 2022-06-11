package com.coolw.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:13
 * @since 1.0
 */
@TableName(value = "user")
@Data
public class UserEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "id_card")
    @NotEmpty(message = "身份证号不能为空")
    private String idCard;

    @TableField(value = "user_name")
    private String userName;

    private String mobile;

    private String address;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;
}
