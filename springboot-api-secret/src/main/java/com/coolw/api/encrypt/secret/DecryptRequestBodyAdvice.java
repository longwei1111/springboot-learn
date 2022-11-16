package com.coolw.api.encrypt.secret;

import com.coolw.api.encrypt.util.SecretUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 响应数据加密处理
 *
 * @author coolw
 * @date 2022/11/16 14:59
 * @since 1.0
 */
@Slf4j
@ControllerAdvice("com.coolw.api.encrypt")
public class DecryptRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Value("secret.key")
    private String secretKey;
    
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        boolean decret = SecretUtils.needDecrypt(parameter);
        if (decret) {
            // TODO 对请求数据进行解密
            return inputMessage;
        }
        return inputMessage;
    }
}
