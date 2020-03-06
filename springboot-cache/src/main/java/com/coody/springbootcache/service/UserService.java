package com.coody.springbootcache.service;

import com.coody.springbootcache.entity.User;

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
