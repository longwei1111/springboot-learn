package com.coolw.api.encrypt.domain.resp;

import com.coolw.common.api.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/11/16 9:24
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResp extends BaseDomain {
    
    private static final long serialVersionUID = -8320766808706334400L;
    
    private Integer id;

    private String mobile;
    
    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;
}
