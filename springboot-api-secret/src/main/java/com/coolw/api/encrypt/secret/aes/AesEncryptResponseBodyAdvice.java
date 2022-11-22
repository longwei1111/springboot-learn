package com.coolw.api.encrypt.secret.aes;

import com.coolw.api.encrypt.annotation.EncryptResponse;
import com.coolw.api.encrypt.exception.EncryptException;
import com.coolw.api.encrypt.secret.SecretConfig;
import com.coolw.api.encrypt.util.AESUtils;
import com.coolw.common.api.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.nio.charset.StandardCharsets;

/**
 * 请求数据解密处理
 *
 * @author coolw
 * @date 2022/11/16 14:56
 * @since 1.0
 */
@Slf4j
@ControllerAdvice("com.coolw.api.encrypt.controller.aes")
public class AesEncryptResponseBodyAdvice implements ResponseBodyAdvice<BaseResponse> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecretConfig secretConfig;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // 优先读取方法上的注解标识
        EncryptResponse methodAnno = methodParameter.getMethodAnnotation(EncryptResponse.class);
        if (methodAnno == null) {
            // 读取类上的注解标识
            EncryptResponse classAnno = methodParameter.getContainingClass().getAnnotation(EncryptResponse.class);
            return classAnno != null && classAnno.value();
        }
        return methodAnno.value();
    }

    @Override
    public BaseResponse beforeBodyWrite(BaseResponse response, MethodParameter methodParameter, MediaType mediaType, Class aClass
            , ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (response == null) {
            return null;
        }
        Object data = response.getData();
        if (data == null) {
            return response;
        }
        byte[] keyBytes = secretConfig.getAesKey().getBytes(StandardCharsets.UTF_8);
        try {
            response.setData(AESUtils.encrypt(objectMapper.writeValueAsBytes(data), keyBytes));
        } catch (Exception e) {
            log.error("加密异常", e);
            throw new EncryptException("加密异常");
        }
        return response;
    }
}
