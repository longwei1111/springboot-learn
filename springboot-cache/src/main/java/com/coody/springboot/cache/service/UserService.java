package com.coody.springboot.cache.service;

import com.coody.springboot.cache.entity.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Author lw
 * @Date 2020-03-05 15:51
 */
public interface UserService {

    User queryUserById(Integer id);

    Integer updateUserById(User user);

    Integer deleteUserById(Integer id);

    User queryUserByName(String username);
}
