package com.coolw.common.enums;

import com.coolw.common.api.ResponseService;
import lombok.AllArgsConstructor;

/**
 * @Description 错误码枚举定义
 * @Date 2021/1/19 10:23
 * @Author coolw
 */
@AllArgsConstructor
public enum ErrCodeEnum implements ResponseService {

    VALIDATTE_FAIL("500", "参数验证失败"),
    SYS_FAIL("999", "系统内部错误");

    private String code;
    private String msg;

    @Override
    public String getResponseCode() {
        return code;
    }

    @Override
    public String getResponseMessage() {
        return msg;
    }
}
