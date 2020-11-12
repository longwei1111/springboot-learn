package com.coolw.exception.exception;

import com.coolw.common.api.ResultResponse;
import com.coolw.common.enums.ErrCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Classname GlobalExceptionHandler
 * @Description 全局异常处理类。@ControllerAdvice 全局异常处理注解，需要配合@ExceptionHandler使用
 *
 * @Author lw
 * @Date 2020-02-24 15:32
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 缺少请求参数异常处理
     *
     * @param ex HttpMessageNotReadableException
     * @return ResultResponse
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultResponse handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return new ResultResponse().fail(ErrCodeEnum.VALIDATTE_FAIL);
    }

    /**
     * 空指针异常处理
     *
     * @param ex NullPointerException
     * @return ResultResponse
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse handleNullPointerException(NullPointerException ex){
        log.error("参数空指针 {}", ex.getMessage());
        return new ResultResponse().fail(ErrCodeEnum.VALIDATTE_FAIL);
    }

    /**
     * 自定义业务异常处理
     *
     * @param businessException
     * @return ResultResponse
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse handleBusinessException(BusinessException businessException) {
        log.error("自定义业务异常");
        String code = businessException.getCode();
        String msg = businessException.getMsg();
        return new ResultResponse().fail(code, msg);
    }

    /**
     * 系统异常,预期以外异常
     *
     * @param ex Exception
     * @return ResultResponse
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse handleUnexceptedServer(Exception ex) {
        log.error("系统异常:", ex);
        return new ResultResponse().fail(ErrCodeEnum.SYS_FAIL);
    }
}
