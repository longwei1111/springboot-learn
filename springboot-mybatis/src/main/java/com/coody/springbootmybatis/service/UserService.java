package com.coody.springbootmybatis.service;

import com.coody.springbootmybatis.entity.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Author lw
 * @Date 2020-02-25 11:36
 */
public interface UserService {

    User getUserByName(String name);

    User getUserById(int id);

    User getUserById_1(int id);

    User getUserByIdAndName(int id, String username);
}
