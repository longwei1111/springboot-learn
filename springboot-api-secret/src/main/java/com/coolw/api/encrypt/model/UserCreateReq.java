package com.coolw.api.encrypt.model;

import com.coolw.common.api.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 用户创建请求
 *
 * @author coolw
 * @date 2022/11/22 13:06
 * @since 1.0
 */
@ApiModel("用户创建请求") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateReq extends BaseDomain {
    
    private static final long serialVersionUID = 6485675679711745899L;
    
    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空")
    private String mobile; 
}
