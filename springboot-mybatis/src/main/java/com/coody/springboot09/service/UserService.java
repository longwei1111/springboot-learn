package com.coody.springboot09.service;

import com.coody.springboot09.entity.User;

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
