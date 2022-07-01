package com.coolw.mybatisplus.sensitive.interceptor;

import com.coolw.mybatisplus.sensitive.annotation.SensitiveData;
import com.coolw.mybatisplus.sensitive.componet.AEScrypto;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.Statement;
import java.util.ArrayList;

/**
 * Mybatis-解密拦截器
 *
 * @author coolw
 * @date 2022/7/1 13:50
 * @since 1.0
 */
@Component
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class MybatisDecryptInterceptor implements Interceptor {
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 结果数据
        Object resultObj = invocation.proceed();
        if (resultObj == null) {
            return null;
        }
        if (resultObj instanceof ArrayList) {
            ArrayList resultList = (ArrayList) resultObj;
            if (!CollectionUtils.isEmpty(resultList) && needToDecrypt(resultList.get(0))) {
                for (Object result : resultList) {
                    AEScrypto.decrypt(result);
                }
            }
        } else {
            if (needToDecrypt(resultObj)) {
                AEScrypto.decrypt(resultObj);
            }
        }

        return resultObj;
    }

    private boolean needToDecrypt(Object obj) {
        Class<?> clazz = obj.getClass();
        SensitiveData sd = clazz.getAnnotation(SensitiveData.class);
        return sd != null; 
    }
    
}
