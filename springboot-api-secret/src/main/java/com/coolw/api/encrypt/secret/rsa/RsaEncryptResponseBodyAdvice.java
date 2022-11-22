package com.coolw.api.encrypt.secret.rsa;

import com.coolw.api.encrypt.annotation.Security;
import com.coolw.api.encrypt.exception.EncryptException;
import com.coolw.api.encrypt.exception.SignException;
import com.coolw.api.encrypt.model.OutsideResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应数据加密处理
 *
 * @author coolw
 * @date 2022/11/16 14:56
 * @since 1.0
 */
@Slf4j
@ControllerAdvice("com.coolw.api.encrypt.controller.rsa")
public class RsaEncryptResponseBodyAdvice extends JsonViewResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecretHolder secretHolder;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(Security.class);
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType
            , ServerHttpRequest request, ServerHttpResponse response) {
        OutsideResponse outsideResponse = (OutsideResponse) bodyContainer.getValue();
        
        Map<String, Object> respMap = new HashMap<>(4);
        respMap.put("timestamp", System.currentTimeMillis() / 1000);
        respMap.put("code", outsideResponse.getCode());
        respMap.put("msg", outsideResponse.getMsg());

        // 用三方公钥对数据加密
        if (outsideResponse.getCode() == 0) {
            try {
                respMap.put("data", objectMapper.writeValueAsString(outsideResponse.getData()));
                secretHolder.encrypt(respMap);
            } catch (Exception e) {
                log.error("加密异常,respMap:{}", respMap, e);
                throw new EncryptException("加密异常");
            }
        }
        // 用我们私钥进行加签
        try {
            secretHolder.sign(respMap);
        } catch (Exception e) {
            log.error("验签异常,respMap:{}", respMap, e);
            throw new SignException("验签异常");
        }

        bodyContainer.setValue(respMap);
    }
}
