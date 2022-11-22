package com.coolw.api.encrypt.model;

import com.coolw.common.api.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 外部响应结果定义(不同的三方要求可能不一样,可以分别定义)
 *
 * @author coolw
 * @date 2022/11/22 8:45
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class OutsideResponse<T> extends BaseDomain {

    private static final long serialVersionUID = 9074758129296913188L;
    
    private Integer code;
    
    private String msg;
    
    private T data;
}
