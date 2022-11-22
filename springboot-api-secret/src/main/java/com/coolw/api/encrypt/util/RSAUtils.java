package com.coolw.api.encrypt.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA工具类
 *
 * @author coolw
 * @date 2022/11/17 16:21
 * @since 1.0
 */
@Slf4j
public class RSAUtils {

    /**
     * 加密算法
     */
    private static final String KEY_ALGORITHM = "RSA";
    /**
     * 签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;
    /**
     * RSA位数。如果为2048，则最大加密明文大小设置为245，最大解密密文大小设置为256
     */
    private static final int INIT_LENGTH = 1024;

    /**
     * 公钥key定义
     */
    private static final String PUBLIC_KEY = "publicKey";
    /**
     * 私钥key定义
     */
    private static final String PRIVATE_KEY = "privateKey";
    /**
     * 编码
     */
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * 生成RSA密钥对
     */
    public static Map<String, String> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(INIT_LENGTH);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, String> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, Base64.encodeBase64String(publicKey.getEncoded()));
        keyMap.put(PRIVATE_KEY, Base64.encodeBase64String(privateKey.getEncoded()));
        return keyMap;
    }

    public static String sign(String data, String privateKey) throws Exception {
        return sign(data.getBytes(StandardCharsets.UTF_8), privateKey);
    }
    
    /**
     * 用私钥对数据生成数字签名(摘要)
     *
     * @param data       加密数据
     * @param privateKey 私钥(base64)
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }

    public static boolean verifySign(String data, String publicKey, String sign) throws Exception {
        return verifySign(data.getBytes(StandardCharsets.UTF_8), publicKey, sign);
    }

    /**
     * 校验数字签名:用公钥对数据生成数字签名(摘要),然后与请求数据中的sign进行比较
     *
     * @param data      加密数据
     * @param publicKey 公钥(base64)
     * @param sign      请求方的数字签名
     */
    public static boolean verifySign(byte[] data, String publicKey, String sign) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }

    /**
     * 私钥解密
     *
     * @param encryptData   密文
     * @param privateKeyStr 私钥
     */
    public static String decryptByPrivateKey(String encryptData, String privateKeyStr) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);

        byte[] b = Base64.decodeBase64(encryptData);
        int inputLen = b.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            byte[] cache;
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(b, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(b, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return new String(decryptedData, CHARSET);
    }

    /**
     * 公钥解密
     *
     * @param encryptData  解密密文
     * @param publicKeyStr 公钥
     */
    public static String decryptByPublicKey(String encryptData, String publicKeyStr) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[] b = Base64.decodeBase64(encryptData);
        int inputLen = b.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            byte[] cache;
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(b, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(b, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return new String(decryptedData, CHARSET);
    }

    /**
     * 公钥加密
     *
     * @param data         加密明文
     * @param publicKeyStr 公钥
     */
    public static String encryptByPublicKey(String data, String publicKeyStr) throws Exception {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);

        byte[] b = data.getBytes(CHARSET);
        int inputLen = b.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            byte[] cache;
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(b, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(b, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return Base64.encodeBase64String(encryptedData);
    }

    /**
     * 私钥加密
     *
     * @param data          加密明文
     * @param privateKeyStr 私钥
     */
    public static String encryptByPrivateKey(String data, String privateKeyStr) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        byte[] b = data.getBytes(StandardCharsets.UTF_8);
        int inputLen = b.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            byte[] cache;
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(b, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(b, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return Base64.encodeBase64String(encryptedData);
    }

    /**
     * 获取私钥
     */
    public static String getPrivateKey(Map<String, String> keyMap) {
        return keyMap.get(PRIVATE_KEY);
    }

    /**
     * 获取公钥
     */
    public static String getPublicKey(Map<String, String> keyMap) {
        return keyMap.get(PUBLIC_KEY);
    }

    public static void main(String[] args) throws Exception {
        /** RSA密钥对 */
        Map<String, String> keyMap = genKeyPair();
        String publicKey = getPublicKey(keyMap);
        String privateKey = getPrivateKey(keyMap);
        log.info("publicKey:{}", publicKey);
        log.info("privateKey:{}", privateKey);

        String str = "一年之计在于春，一日之计在于晨";
        
        /** 私钥加密,公钥解密 */
        String encryptData = encryptByPrivateKey(str, privateKey);
        log.info("私钥加密:{}", encryptData);
        String decryptData = decryptByPublicKey(encryptData, publicKey);
        log.info("公钥解密:{}", decryptData);

        /** 公钥加密,私钥解密 */
        String encryptData1 = encryptByPublicKey(str, publicKey);
        log.info("公钥加密:{}", encryptData1);
        String decryptData1 = decryptByPrivateKey(encryptData1, privateKey);
        log.info("私钥解密:{}", decryptData1);

        /** 数字签名 */
        String sign = sign(str.getBytes(CHARSET), privateKey);
        log.info("sign:{}", sign);
        boolean verify = verifySign(str.getBytes(CHARSET), publicKey, sign);
        log.info("verify sign:{}", verify);
    }
}
