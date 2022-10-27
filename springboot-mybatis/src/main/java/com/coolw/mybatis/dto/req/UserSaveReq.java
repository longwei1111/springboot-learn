package com.coolw.mybatis.dto.req;

import com.coolw.common.api.BaseDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/10/27 10:40
 * @since 1.0
 */
@Getter
@Setter
public class UserSaveReq extends BaseDomain {
    
    private static final long serialVersionUID = -8822058332382398078L;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty("地址")
    private String address;
}
