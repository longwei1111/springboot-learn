package com.coolw.exception.exception;

import com.coolw.exception.result.JsonResult;
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
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult("400", "缺少必要的请求参数");
    }

    /**
     * 空指针异常处理
     *
     * @param ex NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleNullPointerException(NullPointerException ex){
        log.error("参数空指针，{}", ex.getMessage());
        return new JsonResult("401", "参数空指针");
    }

    /**
     * 自定义业务异常处理
     *
     * @param businessException
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleBusinessException(BusinessException businessException) {
        log.error("自定义业务异常");
        String code = businessException.getCode();
        String msg = businessException.getMsg();
        return new JsonResult(code, msg);
    }

    /**
     * 系统异常 预期以外异常
     *
     * @param e Exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexceptedServer(Exception e) {
        log.error("系统异常:", e);
        return new JsonResult("500", "系统发生异常，请联系管理员");
    }
}
