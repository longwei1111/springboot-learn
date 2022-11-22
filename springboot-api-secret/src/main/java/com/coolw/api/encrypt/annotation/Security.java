package com.coolw.api.encrypt.annotation;

import java.lang.annotation.*;

/**
 * 加解密验证
 *
 * @author coolw
 * @date 2022/11/22 8:51
 * @since 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Security {
    
}
