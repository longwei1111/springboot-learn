package com.coody.springbootdruid.controller;

import com.coody.springbootdruid.dao.UserMapper;
import com.coody.springbootdruid.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @GetMapping(value = "/get")
    public User get() {
        return userMapper.getById(1);
    }

    @GetMapping(value = "/list")
    public List<User> list() {
        return userMapper.getList();
    }

}
