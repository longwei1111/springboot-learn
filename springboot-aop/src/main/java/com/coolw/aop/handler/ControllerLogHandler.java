package com.coolw.aop.handler;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.UUID;

/**
 * 日志切面
 *
 * @author coolw
 * @date 2022/5/9 16:10
 * @since 1.0
 */
@Slf4j
@Aspect
@Component
public class ControllerLogHandler {

    private static final ThreadLocal<WebLog> THREAD_LOG = new ThreadLocal<>();

    @Pointcut("execution(* com.coolw.aop.*.controller..*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = jp.getTarget().getClass().getName() + "#" + method.getName();
        String operationName = "";
        ApiOperation operation = method.getAnnotation(ApiOperation.class);
        if (operation != null) {
            operationName = operation.value();
        }
        // 判断是否包含io的入参
        boolean isIOType = false;
        Object[] args = jp.getArgs();
        if (Objects.nonNull(args) && args.length > 0) {
            for (Object arg : args) {
                isIOType = arg instanceof InputStreamSource;
                if (isIOType) {
                    break;
                }
            }
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        WebLog webLog = WebLog.builder()
                .requestId(uuid)
                .methodName(methodName)
                .operationName(operationName)
                .uri(request.getRequestURI())
                .args(args)
                .startTime(System.currentTimeMillis())
                .build();
        THREAD_LOG.set(webLog);
        log.info("流水号:[{}]处理开始,request:{}", webLog.getRequestId(), isIOType ? null : webLog);
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String requestId = THREAD_LOG.get().getRequestId();
        long time = System.currentTimeMillis() - THREAD_LOG.get().getStartTime();
        log.info("流水号:[{}]处理完成,耗时:{}ms,reponse:{}", requestId, time, JSONObject.toJSONString(result));
        clear();
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(Exception e) {
        String requestId = THREAD_LOG.get().getRequestId();
        long time = System.currentTimeMillis() - THREAD_LOG.get().getStartTime();
        log.error("流水号:[{}]处理异常,耗时:{}ms,error:", requestId, time, e);
        clear();
    }

    private void clear() {
        THREAD_LOG.remove();
    }
}
