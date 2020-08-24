package com.coolw.cache.dao;

import com.coolw.cache.entity.User;

/**
 * @Classname UserMapper
 * @Description
 * @Author lw
 * @Date 2020-03-05 15:51
 */
public interface UserMapper {

    User queryUserById(Integer id);

    Integer updateUserById(User user);

    Integer deleteUserById(Integer id);

    User queryUserByName(String username);
}
