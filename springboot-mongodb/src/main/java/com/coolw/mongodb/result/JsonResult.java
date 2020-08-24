package com.coolw.mongodb.result;

import lombok.Data;

/**
 * @Classname JsonResult
 * @Description 统一封装json返回结果
 * @Author lw
 * @Date 2020-02-22 18:09
 */
@Data
public class JsonResult<T> {

    private T data;
    private String code;
    private String msg;

    /**
     * 没有数据返回，默认状态码：0，提示信息：操作成功
     */
    public JsonResult() {
        this.code = "0";
        this.msg = "操作成功";
    }

    /**
     * 没有数据返回，可以指定状态码和提示信息
     *
     * @param code 状态码
     * @param msg 提示信息
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回，默认状态码：0，提示信息：操作成功
     *
     * @param data 数据
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "操作成功";
    }

    /**
     * 有数据返回，状态码为0，指定提示信息
     *
     * @param data 数据
     * @param msg 提示信息
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = "0";
        this.msg = msg;
    }

}
