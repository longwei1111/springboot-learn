package com.coody.springboottransaction.controller;

import com.coody.springboottransaction.entity.User;
import com.coody.springboottransaction.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/insert")
    public Integer insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping("/insert1")
    public Integer insertUser1(@RequestBody User user) throws Exception{
        return userService.insertUser_1(user);
    }

    @PostMapping("/insert2")
    public Integer insertUser2(@RequestBody User user) throws Exception{
        return userService.insertUser_2(user);
    }

    @PostMapping("/insert3")
    public Integer insertUser3(@RequestBody User user) throws Exception{
        return userService.insertUser_3(user);
    }
}
