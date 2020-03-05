package com.coody.springbootcache.controller;

import com.coody.springbootcache.entity.User;
import com.coody.springbootcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String queryUserById(@PathVariable int id) {
        User user1 = userService.queryUserById(id);
        User user2 = userService.queryUserById(id);
        log.info("user1={}", user1);
        log.info("user2={}", user2);
        return "success";
    }

}
