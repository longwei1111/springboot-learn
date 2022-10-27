package com.coolw.common.enums;

import com.coolw.common.api.ResponseService;
import lombok.AllArgsConstructor;

/**
 * @Description 错误码枚举定义
 * @Date 2021/1/19 10:23
 * @Author coolw
 */
@AllArgsConstructor
public enum RespCodeEnum implements ResponseService {

    SUCCESS("000000", "成功"),
    VALIDATTE_FAIL("100000", "参数验证失败"),
    FAIL("999999", "失败");

    private String code;
    private String msg;

    @Override
    public String getRespCode() {
        return code;
    }

    @Override
    public String getRespMsg() {
        return msg;
    }
}
