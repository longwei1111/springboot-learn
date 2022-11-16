package com.coolw.api.encrypt.annotation;

import java.lang.annotation.*;

/**
 * 加密标识
 *
 * @author coolw
 * @date 2022/11/16 10:10
 * @since 1.0
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface EncryptResponse {
    
    boolean value() default true; 
}
