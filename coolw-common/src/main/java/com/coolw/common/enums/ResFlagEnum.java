package com.coolw.common.enums;

import com.coolw.common.api.ResponseService;
import lombok.AllArgsConstructor;

/**
 * @Description 响应标识枚举定义
 * @Date 2021/1/19 10:14
 * @Author coolw
 */
@AllArgsConstructor
public enum ResFlagEnum implements ResponseService {

    SUCCESS("S", "成功"),
    FAIL("F", "失败");

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
