package com.coolw.api.encrypt.domain.req;

import com.coolw.common.api.BaseDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/11/16 17:22
 * @since 1.0
 */
@Getter
@Setter
public class UserSaveReq extends BaseDomain {
    
    private static final long serialVersionUID = 6502258958788360383L;
    
    private String mobile;
    
    private String name;
}
