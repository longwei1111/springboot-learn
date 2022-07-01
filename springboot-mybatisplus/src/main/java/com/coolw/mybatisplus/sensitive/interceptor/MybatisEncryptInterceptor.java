package com.coolw.mybatisplus.sensitive.interceptor;

import com.coolw.mybatisplus.sensitive.annotation.SensitiveData;
import com.coolw.mybatisplus.sensitive.componet.AEScrypto;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;

/**
 * Mybatis-加密拦截器
 *
 * @author coolw
 * @date 2022/7/1 13:50
 * @since 1.0
 */
@Component
@Intercepts({
        @Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class)
})
public class MybatisEncryptInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // @Signature指定了type=parameterHandler后，invocation.getTarget()得到的是parameterHandler 
        ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        // 获取参数对象,即mapper中的paramsType的实例
        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
        parameterField.setAccessible(true);

        // 获取实例
        Object parameterObject = parameterField.get(parameterHandler);
        if (parameterObject != null) {
            Class<?> clazz = parameterObject.getClass();
            // 检查该实例的类是否被@SensitiveData标记
            SensitiveData sensitiveData = AnnotationUtils.findAnnotation(clazz, SensitiveData.class);
            if (sensitiveData != null) {
                // 对该实例类的字段进行加密处理
                Field[] declaredFields = clazz.getDeclaredFields();
                AEScrypto.encrypt(declaredFields, parameterObject);
            }
        }
        return invocation.proceed();
    }
    
}
