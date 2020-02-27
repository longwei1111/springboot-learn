package com.coody.springbootexception.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname JsonResult
 * @Description 定义返回的统一 json 结构
 * @Author lw
 * @Date 2020-02-24 15:29
 */
@Data
@AllArgsConstructor
public class JsonResult {

    /**
     * 异常代码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public JsonResult() {
        this.code = "200";
        this.msg = "操作成功";
    }
}
