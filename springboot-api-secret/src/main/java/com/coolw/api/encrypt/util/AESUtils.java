package com.coolw.api.encrypt.util;

import cn.hutool.core.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * AES工具类
 *
 * @author coolw
 * @date 2022/11/17 10:14
 * @since 1.0
 */
public class AESUtils {

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 获取cipher
     */
    private static Cipher getCipher(byte[] key, int model) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(model, secretKeySpec);
        return cipher;
    }

    /**
     * AES加密
     */
    public static String encrypt(String data, String key) throws Exception {
        return encrypt(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * AES加密
     */
    public static String encrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
        return Base64.encode(cipher.doFinal(data));
    }

    /**
     * AES解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.DECRYPT_MODE);
        return cipher.doFinal(Base64.decode(data)); 
    }

    /**
     * AES解密
     */
    public static String decrypt(String data, String key) throws Exception {
        Cipher cipher = getCipher(key.getBytes(StandardCharsets.UTF_8), Cipher.DECRYPT_MODE);
        byte[] bytes = cipher.doFinal(Base64.decode(data.getBytes(StandardCharsets.UTF_8)));
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
