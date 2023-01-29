package com.coolw.rocketmq.dto;

import com.coolw.common.api.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/12/9 8:37
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends BaseDomain {
    
    private static final long serialVersionUID = -22291315877661728L;
    
    private String name;
    
    private String mobile;
    
    private Integer age;
}
