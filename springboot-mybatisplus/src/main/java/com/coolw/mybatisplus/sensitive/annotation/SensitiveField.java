package com.coolw.mybatisplus.sensitive.annotation;

import java.lang.annotation.*;

/**
 * 敏感字段注解标识
 *
 * @author coolw
 * @date 2022/6/30 22:03
 * @since 1.0
 */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveField {
}
