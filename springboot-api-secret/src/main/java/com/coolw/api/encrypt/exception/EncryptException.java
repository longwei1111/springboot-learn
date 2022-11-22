package com.coolw.api.encrypt.exception;

/**
 * 加密解密异常类
 *
 * @author coolw
 * @date 2022/11/17 10:49
 * @since 1.0
 */
public class EncryptException extends RuntimeException {

    private static final long serialVersionUID = -64611119076461616L;

    public EncryptException(String message) {
        super(message);
    }

    public EncryptException(String message, Throwable e) {
        super(message, e);
    }
}
