package com.coolw.api.encrypt.secret.rsa;

import cn.hutool.core.bean.BeanUtil;
import com.coolw.api.encrypt.annotation.Security;
import com.coolw.api.encrypt.exception.EncryptException;
import com.coolw.api.encrypt.exception.SignException;
import com.coolw.api.encrypt.model.OutsideRequest;
import com.coolw.api.encrypt.secret.SecretConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonInputMessage;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 请求数据解密处理
 *
 * @author coolw
 * @date 2022/11/16 14:59
 * @since 1.0
 */
@Slf4j
@ControllerAdvice("com.coolw.api.encrypt.controller.rsa")
public class RsaDecryptRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecretConfig secretConfig;
    @Autowired
    private SecretHolder encryptHolder;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasMethodAnnotation(Security.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType
            , Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        String request = StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
        OutsideRequest outsideRequest = objectMapper.readValue(request, OutsideRequest.class);

        // 用我们的公钥验签
        Map<String, Object> reqMap = BeanUtil.beanToMap(outsideRequest, false, false);
        try {
            encryptHolder.checkSign(reqMap);
        } catch (Exception e) {
            log.error("验签异常,reqMap:{}", reqMap, e);
            throw new SignException("验签异常");
        }

        // 用三方的私钥解密
        try {
            String decrypt = encryptHolder.decrypt(outsideRequest.getData());
            ByteArrayInputStream inputStream = new ByteArrayInputStream(decrypt.getBytes(StandardCharsets.UTF_8));
            /*return new HttpInputMessage() {
                @Override
                public InputStream getBody() throws IOException {
                    return inputStream;
                }

                @Override
                public HttpHeaders getHeaders() {
                    return inputMessage.getHeaders();
                }
            };*/
            // json格式
            return new MappingJacksonInputMessage(inputStream, inputMessage.getHeaders());
        } catch (Exception e) {
            log.error("解密异常", e);
            throw new EncryptException("解密异常", e);
        }
    }
}
