package com.coolw.mybatisplus.sensitive.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES工具类
 *
 * @author coolw
 * @date 2022/7/1 11:27
 * @since 1.0
 */
@Slf4j
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
            // SecretKey key = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();
            SecretKey key = getSecretKey(password);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(bytes);
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            log.error("加密异常 content:{}", content, e);
            return null;
        }
    }

    /**
     * 解密
     */
    public static String decrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            SecretKey key = getSecretKey(password);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("解密异常 content:{}", content, e);
            return null;
        }
    }
    
    private static SecretKey getSecretKey(String password) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom(password.getBytes(StandardCharsets.UTF_8));
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey();
    }

}
