package com.coolw.redis.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 20:56
 */
@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**  redis:String 类型========================================start */
    /**
     * set redis : String类型
     *
     * @param key
     * @param value
     */
    public void setString(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * get redis : String类型
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    /**  redis:String 类型========================================end */

    /**  redis:Hash 类型========================================start */
    /**
     * set redis: hash类型
     *
     * @param key
     * @param filedKey
     * @param value
     */
    public void setHash(String key, String filedKey, String value) {
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put(key, filedKey, value);
    }

    /**
     * get redis: hash类型
     *
     * @param key
     * @param filedKey
     * @return
     */
    public String getHash(String key, String filedKey) {
        return (String) stringRedisTemplate.opsForHash().get(key, filedKey);
    }
    /**  redis:Hash 类型========================================end */


    /**  redis:List 类型========================================start */
    /**
     * set redis: List类型
     *
     * @param key
     * @param value
     */
    public long setList(String key, String value){
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    /**
     * get redis:list类型
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }
    /**  redis:List 类型========================================end */
}
