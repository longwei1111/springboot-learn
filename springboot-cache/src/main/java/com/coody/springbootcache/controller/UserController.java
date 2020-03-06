package com.coody.springbootcache.controller;

import com.coody.springbootcache.entity.User;
import com.coody.springbootcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname UserController
 * @Description TODO
 * @Author lw
 * @Date 2020-03-05 16:31
 */
@Slf4j
@RestController
@RequestMapping("/cache")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/query/{id}")
    public String queryUserById(@PathVariable Integer id) {
        User user = userService.queryUserById(id);
        log.info("user={}", user);
        return "success";
    }

    @PostMapping("/update")
    public Integer updateUserById(User user) {
        return userService.updateUserById(user);
    }

    @GetMapping("/delete/{id}")
    public Integer deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/user/{username}")
    public User queryUserByName(@PathVariable String username) {
        return userService.queryUserByName(username);
    }

}
