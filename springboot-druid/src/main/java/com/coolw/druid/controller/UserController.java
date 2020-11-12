package com.coolw.druid.controller;

import com.coolw.druid.dao.UserMapper;
import com.coolw.druid.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/user/get")
    public User get() {
        return userMapper.getById(1);
    }

    @GetMapping(value = "/user/list")
    public List<User> list() {
        return userMapper.getList();
    }
}
