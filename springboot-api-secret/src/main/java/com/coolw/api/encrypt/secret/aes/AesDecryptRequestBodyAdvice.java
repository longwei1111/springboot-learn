package com.coolw.api.encrypt.secret.aes;

import com.coolw.api.encrypt.annotation.DecryptRequest;
import com.coolw.api.encrypt.secret.SecretConfig;
import com.coolw.api.encrypt.util.AESUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * 响应数据加密处理
 *
 * @author coolw
 * @date 2022/11/16 14:59
 * @since 1.0
 */
@Slf4j
@ControllerAdvice("com.coolw.api.encrypt.controller.aes")
public class AesDecryptRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Autowired
    private SecretConfig secretConfig;
    
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        // 优先读取方法上的注解标识
        DecryptRequest methodAnno = methodParameter.getMethod().getAnnotation(DecryptRequest.class);
        if (methodAnno == null) {
            // 读取类上的注解标识
            DecryptRequest classAnno = methodParameter.getContainingClass().getAnnotation(DecryptRequest.class);
            return classAnno != null && classAnno.value();
        }
        return methodAnno.value();
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        byte[] body = new byte[inputMessage.getBody().available()];
        inputMessage.getBody().read(body);
        try {
            byte[] decrypt = AESUtils.decrypt(body, secretConfig.getAesKey().getBytes(StandardCharsets.UTF_8));
            final ByteArrayInputStream bais = new ByteArrayInputStream(decrypt);
            return new HttpInputMessage() {
                @Override
                public InputStream getBody() throws IOException {
                    return bais;
                }

                @Override
                public HttpHeaders getHeaders() {
                    return inputMessage.getHeaders();
                }
            };
        } catch (Exception e) {
            log.error("解密异常", e);
        }
        return super.beforeBodyRead(inputMessage, parameter, targetType, converterType);
    }
}
