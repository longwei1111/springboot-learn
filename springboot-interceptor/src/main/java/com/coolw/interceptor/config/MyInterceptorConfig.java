package com.coolw.interceptor.config;

import com.coolw.interceptor.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

///**
// * @Description
// *          自定义拦截器的配置，继承WebMvcConfigurationSupport会导致Spring Boot对mvc的自动配置失效，但可以在前后端分离项目中；
// *          如果需要让Spring Boot的自动配置生效，需要重写addResourceHandlers方法，将自动配置的路径放开；
// * @Author coolw
// * @Date 2020-02-25 19:51
// */
//@Configuration
//public class MyInterceptorConfig extends WebMvcConfigurationSupport {
//
//    /**
//     * 将自定义拦截器添加进去，addPathPatterns方法是添加要拦截的请求
//     *
//     * @param registry
//     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//
//    /**
//     * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
//     *
//     * @param registry
//     */
//    /*@Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }*/
//}

/**
 * 自定义拦截器的配置，实现WebMvcConfigurer不会导致Spring Boot对mvc的自动配置失效，可以用在非前后端分离的项目中
 * @Author coolw
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    /**
     * 解决静态资源被拦截问题
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}