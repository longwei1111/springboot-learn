package com.coolw.mybatis.handler;

import com.coolw.common.api.BaseResponse;
import com.coolw.common.enums.RespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 全局异常处理类。@ControllerAdvice 全局异常处理注解，需要配合@ExceptionHandler使用
 * @Author coolw
 * @Date 2020-02-24 15:32
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 缺少请求参数异常处理
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("缺少请求参数", ex);
        return BaseResponse.fail();
    }

    /**
     * 方法入参校验异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse hadnleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("方法入参异常", ex);
        return BaseResponse.fail();
    }
    
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleNullPointerException(NullPointerException ex){
        log.error("空指针", ex);
        return BaseResponse.fail();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleException(Exception ex) {
        log.error("系统异常", ex);
        return BaseResponse.fail(RespCodeEnum.FAIL);
    }
}
