package com.coolw.kafka.dto;

import com.coolw.common.api.BaseDomain;
import lombok.*;

/**
 * 用户消息DTO
 *
 * @author coolw
 * @date 2022/7/22 11:24
 * @since 1.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSyncDTO extends BaseDomain {
    
    private static final long serialVersionUID = 6393893871856789420L;
    
    private String username;
    
    private String mobile;
    
    private String address;
}
