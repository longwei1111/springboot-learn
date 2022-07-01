package com.coolw.mybatisplus.sensitive.annotation;

import java.lang.annotation.*;

/**
 * 敏感类注解标识
 *
 * @author coolw
 * @date 2022/6/30 22:03
 * @since 1.0
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveData {
}
