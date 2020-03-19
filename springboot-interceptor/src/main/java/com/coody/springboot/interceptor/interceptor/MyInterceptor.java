package com.coody.springboot.interceptor.interceptor;

import com.coody.springboot.interceptor.annotation.UnInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Classname MyInterceptor
 * @Description 自定义拦截器
 * @Author lw
 * @Date 2020-02-25 19:45
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 定义拦截器：需要实现 HandlerInterceptor 接口
     *
     * HandlerInterceptor接口中有3个方法
     * 1.preHandle：在业务处理器处理请求之前被调用
     * 2.postHandle：在业务处理器处理请求执行完成后，生成视图之前执行（还未渲染页面））
     * 3.afterCompletion：在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("===拦截到了方法：{}，在该方法执行之前执行===", methodName);

        // 判断用户有没有登陆，一般登陆后的用户都有一个对应的token
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            log.info("用户没有登陆，没有执行权限......请登陆");
            return false;
        }

        // 通过方法，可以获取该方法上的自定义注解，然后通过注解来判断该方法是否要被拦截
        // @UnInterceptor 自定义注解，不被拦截
        UnInterceptor unInterceptor = method.getAnnotation(UnInterceptor.class);
        if (null == unInterceptor) {
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("执行完方法之后进行（Controller方法调用之后），但是此时还没有进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("整个请求都处理完毕，DispatcherServlet也渲染了对应的视图，此时可以做一些清理的工作等等");
    }
}
