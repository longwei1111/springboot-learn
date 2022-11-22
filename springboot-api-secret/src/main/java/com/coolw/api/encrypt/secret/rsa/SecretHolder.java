package com.coolw.api.encrypt.secret.rsa;

import com.coolw.api.encrypt.exception.SignException;
import com.coolw.api.encrypt.secret.SecretConfig;
import com.coolw.api.encrypt.util.AESUtils;
import com.coolw.api.encrypt.util.RSAUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/11/22 8:55
 * @since 1.0
 */
@Component
public class SecretHolder {

    /*@Autowired
    private ObjectMapper objectMapper;*/
    @Autowired
    private SecretConfig secretConfig;

    /**
     * 用三方公钥对业务数据加密
     */
    public void encrypt(Map<String, Object> body) throws Exception {
        String data = (String) body.get("data");
        // AES对数据加密
        String encryptAes = AESUtils.encrypt(data, secretConfig.getAesKey());
        // json格式写入
        //String encryptAes = AESUtils.encrypt(objectMapper.writeValueAsString(data), secretConfig.getAesKey());
        // RSA加密
        String encryptData = RSAUtils.encryptByPublicKey(encryptAes, secretConfig.getThirdRsaPublicKey());
        body.put("data", encryptData);
    }

    /**
     * 用我们私钥进行加签
     */
    public void sign(Map<String, Object> body) throws Exception {
        ArrayList<String> list = new ArrayList<>(body.size());
        for (Map.Entry<String, Object> entry : body.entrySet()) {
            list.add(entry.getKey() + "=" + entry.getValue());
        }
        Collections.sort(list);
        String content = StringUtils.join(list, "&");
        String sign = RSAUtils.sign(content, secretConfig.getOurRsaPrivateKey());
        body.put("sign", sign);
    }

    /**
     * 用我们公钥进行验签
     */
    public void checkSign(Map<String, Object> body) throws Exception {
        String sign = (String) body.get("sign");
        Assert.isTrue(StringUtils.isNotBlank(sign), "验签失败,sign为空");

        ArrayList<String> list = new ArrayList<>(body.size());
        for (Map.Entry<String, Object> e : body.entrySet()) {
            // sign字段不进行验签
            if (!"sign".equals(e.getKey())) {
                list.add(e.getKey() + "=" + e.getValue());
            }
        }
        Collections.sort(list);
        String content = StringUtils.join(list, "&");
        boolean verifySign = RSAUtils.verifySign(content, secretConfig.getOurRsaPublicKey(), sign);
        if (!verifySign) {
            throw new SignException("验签失败");
        }
    }

    /**
     * 用三方私钥进行数据解密
     */
    public String decrypt(String data) throws Exception {
        // RSA解密
        String decryptAes = RSAUtils.decryptByPrivateKey(data, secretConfig.getThirdRsaPrivateKey());
        // AES解密
        return AESUtils.decrypt(decryptAes, secretConfig.getAesKey());
        //return RSAUtils.decryptByPrivateKey(data, secretConfig.getThirdRsaPrivateKey());
    }
}

