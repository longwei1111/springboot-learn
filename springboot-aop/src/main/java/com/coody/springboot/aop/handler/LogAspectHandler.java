package com.coody.springboot.aop.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname LogAspectHandler
 * @Description 日志切面处理类
 * @Author lw
 * @Date 2020-02-24 17:37
 */
@Slf4j
@Aspect
@Component
public class LogAspectHandler {

    /*
     * @Aspect 描述一个切面类
     *
     * 常用注解：
     * 1.@Pointcut：定义一个切面，即上面所描述的关注的某件事入口。
     * 2.@Before：在做某件事之前做的事。
     * 3.@After：在做某件事之后做的事。
     * 4.@AfterReturning：在做某件事之后，对其返回值做增强处理。
     * 5.@AfterThrowing：在做某件事抛出异常时，处理。
     */

    /**
     * 定义一个切面，拦截com.coody.springbootaop.controller包及子包中的所有方法
     * <p>
     * execution() 为表达式主体
     * 第一个 * 号的位置：表示返回值类型，* 表示所有类型
     * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.coody.springbootaop.controller 包及子包下所有类的方法
     * 第二个 * 号的位置：表示类名，* 表示所有类
     * *(..) ：这个星号表示方法名，* 表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(* com.coody.springboot.aop.controller..*.*(..))")
    public void pointcut() {
    }

    /**
     * annotation() 方式是针对某个注解来定义切面，对具有@GetMapping注解的方法做切面
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotationCut() {
        log.info("拦截@GetMapping注解的方法");
    }

    /**
     * 前置通知。@Before 注解指定的方法在切面切入目标方法之前执行
     *
     * @param joinPoint
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("=== doBefore方法进入了 ===");

        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取执行的方法名
        String funcName = signature.getName();
        log.info("即将执行的方法为{}，属于{}包", funcName, declaringTypeName);

        // 获取请求的url和ip
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 请求url
        String url = request.getRequestURI();
        // ip
        String ip = request.getRemoteAddr();
        log.info("用户请求的url={},ip={}", url, ip);
    }

    /**
     * 最终通知。@After 注解指定的方法在切面切入目标方法之后执行
     *
     * @param joinPoint
     */
    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("===== doAfter方法进入了 =====");

        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取执行的方法名
        String method = signature.getName();
        log.info("方法{}已经执行完", method);
    }

    /**
     * 后置通知。@AfterReturning和@After 有些类似，区别在于 @AfterReturning 注解可以用来捕获切入方法执行完之后的返回值，
     * 对返回值进行业务逻辑上的增强处理
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("===== doAfterReturning =====");

        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取执行的方法名
        String method = signature.getName();
        log.info("方法{}已经执行完，返回参数result={}", method, result);
        // 实际项目中可以根据业务做具体的返回值增强
        log.info("方法{}已经执行完，返回参数result={}", method, result + "增强版");
    }

    /**
     * 异常通知。@AfterThrowing 注解是当被切方法执行时抛出异常时，会进入 @AfterThrowing 注解的方法中执行
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取执行的方法名
        String method = signature.getName();
        // 处理异常的逻辑
        log.info("执行方法{}出错，异常为：{}", method, ex);
    }

    /**
     * 环绕通知：自定义通知
     * 必须有返回值：Object
     * 必须有参数：ProceedingJoinPoint
     * 必须抛出异常：throws Throwable
     */
    //@Around("pointcut()")
    public Object test5(ProceedingJoinPoint pjp) throws Throwable {
        try {
            log.info("----------- 前置通知");

            // 调用目标对象的方法
            Object ret = pjp.proceed();

            log.info("----------- 后置通知");

            return ret;
        } catch (Throwable ex) {
            log.info("----------- 异常通知");
            throw ex;
        } finally {
            log.info("----------- 最终通知");
        }
    }
}
