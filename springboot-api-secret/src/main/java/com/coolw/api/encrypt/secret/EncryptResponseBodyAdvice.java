package com.coolw.api.encrypt.secret;

import com.coolw.api.encrypt.util.SecretUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 请求数据解密处理
 *
 * @author coolw
 * @date 2022/11/16 14:56
 * @since 1.0
 */
@ControllerAdvice("com.coolw.api.encrypt")
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice {
    
    @Value("secret.key")
    private String secretKey;
    
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        boolean encret = SecretUtils.needEncrypt(methodParameter);
        if (encret) {
            // TODO 对响应数据加密
            return obj;
        }
        return obj;
    }
}
