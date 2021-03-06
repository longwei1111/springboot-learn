package com.coolw.redis.controller;

import com.alibaba.fastjson.JSON;
import com.coolw.redis.entity.User;
import com.coolw.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 21:01
 */
@Slf4j
@RestController
public class RedisController {

    @Resource
    private RedisService redisService;

    @GetMapping("/redis/testString")
    public void testString() {
        // 测试redis的String类型
        redisService.setString("lw", "123456");
        log.info("密码={}", redisService.getString("lw"));

        // 如果是实体对象，可以使用json工具转成json字符串
        User user = new User("coody", "666666");
        redisService.setString("userInfo", JSON.toJSONString(user));
        log.info("userInfo={}", redisService.getString("userInfo"));
    }

    @GetMapping("/redis/testHash")
    public void testHash() {
        // 测试redis的Hash类型
        redisService.setHash("coody", "上海", "zhangsan");
        log.info("name={}", redisService.getHash("coody", "上海"));
    }

    @GetMapping("/redis/testList")
    public void testList() {
        // 测试redis的List类型
        redisService.setList("city", "上海");
        redisService.setList("city", "北京");
        redisService.setList("city", "深圳");
        List<String> valList = redisService.getList("city", 0, -1);
        valList.forEach(val ->{
            log.info("list中有：{}", val);
        });
    }
}
