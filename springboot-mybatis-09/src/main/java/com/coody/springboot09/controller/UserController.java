package com.coody.springboot09.controller;

import com.coody.springboot09.entity.User;
import com.coody.springboot09.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname UserController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-25 11:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/getUserByName/{name}")
    public User getUserByname(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserById_1/{id}")
    public User getUserById_1(@PathVariable int id) {
        return userService.getUserById_1(id);
    }

    @GetMapping("/getUserByIdAndName/{id}/{name}")
    public User getUserByIdAndName(@PathVariable int id, @PathVariable("name") String username) {
        return userService.getUserByIdAndName(id, username);
    }
}
