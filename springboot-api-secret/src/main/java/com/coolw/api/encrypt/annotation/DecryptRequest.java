package com.coolw.api.encrypt.annotation;

import java.lang.annotation.*;

/**
 * 解密标识
 *
 * @author coolw
 * @date 2022/11/16 14:52
 * @since 1.0
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DecryptRequest {
    
    boolean value() default true;
}
