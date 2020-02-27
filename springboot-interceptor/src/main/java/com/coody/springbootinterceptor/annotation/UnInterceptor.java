package com.coody.springbootinterceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname UnInterceptor
 * @Description 自定义注解。该注解用来指定某个方法不用拦截
 * @Author lw
 * @Date 2020-02-25 20:42
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnInterceptor {

}
