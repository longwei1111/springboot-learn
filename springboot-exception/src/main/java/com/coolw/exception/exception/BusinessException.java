package com.coolw.exception.exception;

import com.coolw.exception.enums.BusinessMsgEnum;

/**
 * @Classname BusinessException
 * @Description 自定义异常
 * @Author lw
 * @Date 2020-02-24 17:16
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3088266348333360419L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常提示信息
     */
    private String msg;

    public BusinessException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.getCode();
        this.msg = businessMsgEnum.getMsg();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }
}
