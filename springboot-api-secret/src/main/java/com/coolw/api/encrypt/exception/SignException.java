package com.coolw.api.encrypt.exception;

/**
 * 加签验签异常类
 *
 * @author coolw
 * @date 2022/11/22 12:54
 * @since 1.0
 */
public class SignException extends RuntimeException {

    private static final long serialVersionUID = 3451106457615946610L;
    
    public SignException(String message) {
        super(message);
    }
    
    public SignException(String message, Throwable e) {
        super(message, e);
    }
}
