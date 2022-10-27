package com.coolw.mybatis.dto.req;

import com.coolw.common.api.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 更新用户状态
 *
 * @author coolw
 * @date 2022/7/5 8:48
 * @since 1.0
 */
@Getter
@Setter
public class UpdateUserStatusReq extends BaseDomain {
    
    private static final long serialVersionUID = -7046238452755150188L;
    
    @NotBlank(message = "[用户号]不能为空")
    private String userNo;

    @NotBlank(message = "[用户状态]不能为空")
    private String userStatus;
}
