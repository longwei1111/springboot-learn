package com.coody.springboot.cache.dao;

import com.coody.springboot.cache.entity.User;

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
