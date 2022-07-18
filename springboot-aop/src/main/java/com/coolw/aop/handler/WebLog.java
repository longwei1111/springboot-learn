package com.coolw.aop.handler;

import com.alibaba.fastjson.annotation.JSONField;
import com.coolw.common.api.BaseDomain;
import lombok.*;

/**
 * web日志
 *
 * @author coolw
 * @date 2022/5/9 16:10
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebLog extends BaseDomain {

    private static final long serialVersionUID = 1441227672396021146L;
    
    /** 请求流水号 */
    @JSONField(serialize = false)
    private String requestId;

    /** 方法名 */
    private String methodName;

    /** 操作名 */
    private String operationName;
    
    /** 请求URI */
    private String uri;

    /** 参数 */
    private Object args;

    /** 开始时间戳 */
    @JSONField(serialize = false)
    private Long startTime;
}
