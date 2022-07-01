package com.coolw.mybatisplus.domain.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.coolw.common.api.BaseDomain;
import com.coolw.mybatisplus.sensitive.annotation.SensitiveData;
import com.coolw.mybatisplus.sensitive.annotation.SensitiveField;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/7/1 15:39
 * @since 1.0
 */
@SensitiveData
@Getter
@Setter
public class UserSaveReq extends BaseDomain {

    private static final long serialVersionUID = 4261283428149166940L;

    @NotEmpty(message = "身份证号不能为空")
    private String idCard;

    @TableField(value = "user_name")
    private String userName;

    @SensitiveField
    private String password;

    private String mobile;

    private String address;
}
