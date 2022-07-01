package com.coolw.mybatisplus.domain.req;

import com.coolw.common.api.BaseDomain;
import com.coolw.mybatisplus.sensitive.annotation.SensitiveData;
import com.coolw.mybatisplus.sensitive.annotation.SensitiveField;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/7/1 15:15
 * @since 1.0
 */
@SensitiveData
@Getter
@Setter
public class UserQueryReq extends BaseDomain {
    
    private static final long serialVersionUID = -2655475208009669481L;
    
    private String userName;
    
    @SensitiveField
    private String password;
}
