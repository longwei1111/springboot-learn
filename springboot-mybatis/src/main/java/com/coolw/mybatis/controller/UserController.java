package com.coolw.mybatis.controller;

import com.coolw.mybatis.entity.User;
import com.coolw.mybatis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname UserController
 * @Description
 * @Author lw
 * @Date 2020-02-25 11:38
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/getUserByName/{name}")
    public User getUserByname(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/user/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/getUserById_1/{id}")
    public User getUserById_1(@PathVariable int id) {
        return userService.getUserById_1(id);
    }

    @GetMapping("/user/getUserByIdAndName/{id}/{name}")
    public User getUserByIdAndName(@PathVariable int id, @PathVariable("name") String username) {
        return userService.getUserByIdAndName(id, username);
    }
}
