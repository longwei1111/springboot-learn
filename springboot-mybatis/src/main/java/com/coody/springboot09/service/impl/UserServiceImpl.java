package com.coody.springboot09.service.impl;

import com.coody.springboot09.dao.UserMapper;
import com.coody.springboot09.entity.User;
import com.coody.springboot09.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author lw
 * @Date 2020-02-25 11:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        log.info("根据客户名称获取客户信息，name={}", name);
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserByIdAndName(int id, String username) {
        log.info("根据主键id和客户姓名获取客户信息，id={}，username={}", id, username);
        return userMapper.getUserByIdAndName(id, username);
    }

    @Override
    public User getUserById(int id) {
        log.info("根据主键id(方式1)获取客户信息，id={}", id);
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserById_1(int id) {
        log.info("根据主键id(方式2)获取客户信息，id={}", id);
        return userMapper.getUserById_1(id);
    }
}
