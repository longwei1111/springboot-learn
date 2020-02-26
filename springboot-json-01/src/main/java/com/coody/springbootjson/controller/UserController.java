package com.coody.springbootjson.controller;

import com.coody.springbootjson.result.JsonResult;
import com.coody.springbootjson.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname UserController
 * @Description 用户信息
 * @Author lw
 * @Date 2020-02-22 17:27
 */
@RestController
@RequestMapping("/json")
public class UserController {

    /**
     * 1.@RestController注解包含@Controller和@ResponseBody注解
     * 2.@ResponseBody将返回的数据转换成json格式
     * 3.Spring Boot默认支持jackson
     */

    /**
     * 获取单个实体对象
     *
     * @return
     */
    @RequestMapping("/user")
    public User getUser() {
        return new User(1, "zhangsan", "123456");
    }

    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping("/userList")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "zhangsan", "123456"));
        userList.add(new User(2, "lisi", "123456"));
        return userList;
    }

    /**
     * 获取map
     *
     * @return
     */
    @RequestMapping("getMap")
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
     *
     * @return
     */
    @RequestMapping("/userJson")
    public JsonResult<User> getUserJson() {
        User user = new User(1, "zhangsan", "123456");
        return new JsonResult<>(user);
    }

    /**
     * 获取实体对象列表-json
     *
     * @return
     */
    @RequestMapping("/userListJson")
    public JsonResult<List<User>> getUserListJson() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "zhangsan", "123456"));
        userList.add(new User(2, "lisi", "123456"));
        return new JsonResult<>(userList, "获取用户列表成功");
    }

    /**
     * 获取map-json
     *
     * @return
     */
    @RequestMapping("getMapJson")
    public JsonResult<Map<String, Object>> getMapJson() {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, "zhangsan", "123456");
        map.put("用户信息", user);
        map.put("博客地址", "https://www.cnblogs.com/lwcode6/");
        map.put("住址", null);
        return new JsonResult<>(map);
    }
}
