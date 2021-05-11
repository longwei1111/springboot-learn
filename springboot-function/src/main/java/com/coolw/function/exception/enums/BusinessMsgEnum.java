package com.coolw.function.exception.enums;

/**
 * @Classname BusinessMsgEnum
 * @Description 业务异常提示信息枚举类
 * @Author lw
 * @Date 2020-02-24 17:10
 */
public enum BusinessMsgEnum {

    /** 参数异常 */
    PARAMETER_EXCEPTION("102", "参数异常"),
    /** 等待异常 */
    SERVICE_TIME_OUT("103", "服务调用超时"),
    /** 500,一劳永逸 */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员！");

    /**
     * 消息码
     */
    private String code;

    /**
     * 消息内容
     */
    private String msg;

    BusinessMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
