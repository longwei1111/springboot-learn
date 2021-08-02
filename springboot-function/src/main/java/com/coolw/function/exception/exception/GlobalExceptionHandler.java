package com.coolw.function.exception.exception;

import com.coolw.common.api.Response;
import com.coolw.common.enums.ErrCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description 全局异常处理类。@ControllerAdvice 全局异常处理注解，需要配合@ExceptionHandler使用
 * @Author coolw
 * @Date 2020-02-24 15:32
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 缺少请求参数异常处理
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return new Response().fail(ErrCodeEnum.VALIDATTE_FAIL);
    }

    /**
     * 空指针异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleNullPointerException(NullPointerException ex){
        log.error("参数空指针 {}", ex.getMessage());
        return new Response().fail(ErrCodeEnum.VALIDATTE_FAIL);
    }

    /**
     * 自定义业务异常处理
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleBusinessException(BusinessException businessException) {
        log.error("自定义业务异常");
        String code = businessException.getCode();
        String msg = businessException.getMsg();
        return new Response().fail(code, msg);
    }

    /**
     * 系统异常,预期以外异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleUnexceptedServer(Exception ex) {
        log.error("系统异常:", ex);
        return new Response().fail(ErrCodeEnum.SYS_FAIL);
    }
}
