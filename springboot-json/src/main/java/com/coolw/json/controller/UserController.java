package com.coolw.json.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.json.entity.Cust;
import com.coolw.json.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-22 17:27
 */
@RestController
public class UserController {

    /*
     * 1.@RestController注解包含@Controller和@ResponseBody注解
     * 2.@ResponseBody将返回的数据转换成json格式
     * 3.Spring Boot默认支持jackson
     */

    /**
     * 获取单个实体对象
     */
    @RequestMapping("/json/user")
    public User getUser() {
        return new User(1, "zhangsan", "123456");
    }

    /**
     * 获取列表
     */
    @RequestMapping("/json/userList")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "zhangsan", "123456"));
        userList.add(new User(2, "lisi", "123456"));
        return userList;
    }

    /**
     * 获取map
     */
    @RequestMapping("/json/getMap")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, "zhangsan", "123456");
        map.put("用户信息", user);
        map.put("博客地址", "https://www.cnblogs.com/lwcode6/");
        map.put("住址", null);
        return map;
    }

    /**
     * 获取实体对象-json
     */
    @RequestMapping("/json/userJson")
    public BaseResponse<User> getUserJson() {
        User user = new User(1, "zhangsan", "123456");
        return BaseResponse.success(user);
    }

    /**
     * 获取实体对象列表-json
     */
    @RequestMapping("/json/userListJson")
    public BaseResponse<List<User>> getUserListJson() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "zhangsan", "123456"));
        userList.add(new User(2, "lisi", "123456"));
        return BaseResponse.success(userList);
    }

    /**
     * 获取map-json
     */
    @RequestMapping("/json/getMapJson")
    public BaseResponse<Map<String, Object>> getMapJson() {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, "zhangsan", "123456");
        map.put("用户信息", user);
        map.put("博客地址", "https://www.cnblogs.com/lwcode6/");
        map.put("住址", null);
        return BaseResponse.success(map);
    }

    @GetMapping("/json/now")
    public Map now(){
        Map map = new HashMap();
        map.put("name", "梁朝伟");
        map.put("time", new Date());
        map.put("amt", new BigDecimal(60.00));
        map.put("amt_1", new BigDecimal("60.00"));

        Cust cust = new Cust();
        map.put("money", cust.getMoney());
        return map;
    }
}
