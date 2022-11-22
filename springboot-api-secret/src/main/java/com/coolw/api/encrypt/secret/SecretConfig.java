package com.coolw.api.encrypt.secret;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/11/17 11:27
 * @since 1.0
 */
@Data
@Component
public class SecretConfig {
    
    @Value("${secret.aes.key}")
    private String aesKey;
    
    @Value("${secret.rsa.our.publicKey}")
    private String ourRsaPublicKey;

    @Value("${secret.rsa.our.privateKey}")
    private String ourRsaPrivateKey;

    @Value("${secret.rsa.third.publicKey}")
    private String thirdRsaPublicKey;

    @Value("${secret.rsa.third.privateKey}")
    private String thirdRsaPrivateKey;
}
