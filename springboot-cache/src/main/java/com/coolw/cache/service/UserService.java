package com.coolw.cache.service;

import com.coolw.cache.entity.User;

/**
 * @Classname UserService
 * @Description
 * @Author lw
 * @Date 2020-03-05 15:51
 */
public interface UserService {

    User queryUserById(Integer id);

    Integer updateUserById(User user);

    Integer deleteUserById(Integer id);

    User queryUserByName(String username);
}
