package com.coolw.transaction.controller;

import com.coolw.transaction.entity.User;
import com.coolw.transaction.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 11:38
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/insert")
    public Integer insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping("/user/insert1")
    public Integer insertUser1(@RequestBody User user) throws Exception{
        return userService.insertUser_1(user);
    }

    @PostMapping("/user/insert2")
    public Integer insertUser2(@RequestBody User user) {
        return userService.insertUser_2(user);
    }

    @PostMapping("/user/insert3")
    public Integer insertUser3(@RequestBody User user) {
        return userService.insertUser_3(user);
    }
}
