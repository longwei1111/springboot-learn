package com.coolw.cache.controller;

import com.coolw.cache.entity.User;
import com.coolw.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname UserController
 * @Description
 * @Author lw
 * @Date 2020-03-05 16:31
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/cache/query/{id}")
    public String queryUserById(@PathVariable Integer id) {
        User user = userService.queryUserById(id);
        log.info("user={}", user);
        return "success";
    }

    @PostMapping("/cache/update")
    public Integer updateUserById(User user) {
        return userService.updateUserById(user);
    }

    @GetMapping("/cache/delete/{id}")
    public Integer deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/cache/user/{username}")
    public User queryUserByName(@PathVariable String username) {
        return userService.queryUserByName(username);
    }
}
