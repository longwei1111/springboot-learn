package com.coolw.api.encrypt.util;

import com.coolw.api.encrypt.annotation.DecryptRequest;
import com.coolw.api.encrypt.annotation.EncryptResponse;
import org.springframework.core.MethodParameter;

/**
 * 判断是否需要加解密工具类
 *
 * @author coolw
 * @date 2022/11/16 15:01
 * @since 1.0
 */
public final class SecretUtils {

    /**
     * 是否需要加密,true:需要
     */
    public static boolean needEncrypt(MethodParameter methodParameter) {
        // 优先读取方法上的注解标识
        EncryptResponse methodAnno = methodParameter.getMethodAnnotation(EncryptResponse.class);
        if (methodAnno == null) {
            // 读取类上的注解标识
            EncryptResponse classAnno = methodParameter.getContainingClass().getAnnotation(EncryptResponse.class);
            return classAnno != null && classAnno.value();
        }
        return methodAnno.value();
    }

    /**
     * 是否需要解密,true:需要
     */
    public static boolean needDecrypt(MethodParameter methodParameter) {
        // 优先读取方法上的注解标识
        DecryptRequest methodAnno = methodParameter.getMethod().getAnnotation(DecryptRequest.class);
        if (methodAnno == null) {
            // 读取类上的注解标识
            DecryptRequest classAnno = methodParameter.getContainingClass().getAnnotation(DecryptRequest.class);
            return classAnno != null && classAnno.value();
        }
        return methodAnno.value();
    }
}
