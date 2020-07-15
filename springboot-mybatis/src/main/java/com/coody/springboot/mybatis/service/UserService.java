package com.coody.springboot.mybatis.service;

import com.coody.springboot.mybatis.entity.User;

/**
 * @Classname UserService
 * @Description
 * @Author lw
 * @Date 2020-03-05 15:51
 */
public interface UserService {

    User getUserByName(String name);

    User getUserById(int id);

    User getUserById_1(int id);

    User getUserByIdAndName(int id, String username);
}
