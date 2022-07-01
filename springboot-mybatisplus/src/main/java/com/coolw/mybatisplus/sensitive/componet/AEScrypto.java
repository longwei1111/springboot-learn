package com.coolw.mybatisplus.sensitive.componet;

import com.coolw.mybatisplus.sensitive.annotation.SensitiveField;
import com.coolw.mybatisplus.sensitive.util.AESUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;

/**
 * 加解密处理类
 *
 * @author coolw
 * @date 2022/7/1 10:32
 * @since 1.0
 */
@Component
public class AEScrypto {

    /**
     * 密码器
     */
    @Value("${crypto.key}")
    private String cryptoKey;

    private static String password;

    @PostConstruct
    public void init() {
        password = cryptoKey;
    }

    /**
     * 加密
     */
    public static <T> T encrypt(Field[] declaredFields, T paramsObject) throws IllegalAccessException {
        for (Field field : declaredFields) {
            // 敏感字段
            SensitiveField sf = field.getAnnotation(SensitiveField.class);
            if (sf != null) {
                field.setAccessible(true);
                Object obj = field.get(paramsObject);
                // 暂仅支持String类型的字段加密
                if (obj instanceof String) {
                    String val = (String) obj;
                    if (StringUtils.hasLength(val)) {
                        // 加密
                        field.set(paramsObject, AESUtil.encrypt(val, password));
                    }
                }
            }
        }
        return paramsObject;
    }

    /**
     * 解密
     */
    public static <T> T decrypt(T result) throws IllegalAccessException {
        Class<?> clazz = result.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 敏感字段
            SensitiveField sf = field.getAnnotation(SensitiveField.class);
            if (sf != null) {
                field.setAccessible(true);
                Object obj = field.get(result);
                // 暂仅支持String类型的字段解密
                if (obj instanceof String) {
                    String val = (String) obj;
                    if (StringUtils.hasLength(val)) {
                        // 解密
                        field.set(result, AESUtil.decrypt(val, password));
                    }
                }
            }
        }
        return result;
    }

}
