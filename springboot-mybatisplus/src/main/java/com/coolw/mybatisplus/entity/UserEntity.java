package com.coolw.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.coolw.mybatisplus.sensitive.annotation.SensitiveData;
import com.coolw.mybatisplus.sensitive.annotation.SensitiveField;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 用户实体类
 *
 * @author coolw
 * @date 2021/12/21 13:13
 * @since 1.0
 */
@SensitiveData
@TableName(value = "user")
@Data
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 3473309747286006030L;
    
    @TableField(value = "id_card")
    @NotEmpty(message = "身份证号不能为空")
    private String idCard;

    @TableField(value = "user_name")
    private String userName;
    
    @SensitiveField
    private String password;

    private String mobile;

    private String address;
}
