package com.coody.springboot01.controller;

import com.coody.springboot01.common.JsonResult;
import com.coody.springboot01.entity.User;
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

    @RequestMapping("/user")
    public User getUser() {
        return new User(1, "龙伟", "123456");
    }

    @RequestMapping("/userList")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "危必元", "123456"));
        userList.add(new User(2, "龙伊涵", "123456"));
        return userList;
    }

    @RequestMapping("getMap")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, "龙伟", "123456");
        map.put("用户信息", user);
        map.put("博客地址", "https://www.cnblogs.com/lwcode6/");
        map.put("住址", null);
        return map;
    }

    @RequestMapping("/userJson")
    public JsonResult<User> getUserJson() {
        User user = new User(1, "龙伟", "123456");
        return new JsonResult<>(user);
    }

    @RequestMapping("/userListJson")
    public JsonResult<List<User>> getUserListJson() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "危必元", "123456"));
        userList.add(new User(2, "龙伊涵", "123456"));
        return new JsonResult<>(userList, "获取用户列表成功");
    }

    @RequestMapping("getMapJson")
    public JsonResult<Map<String, Object>> getMapJson() {
        Map<String, Object> map = new HashMap<>();
        User user = new User(1, "龙伟", "123456");
        map.put("用户信息", user);
        map.put("博客地址", "https://www.cnblogs.com/lwcode6/");
        map.put("住址", null);
        return new JsonResult<>(map);
    }

}
