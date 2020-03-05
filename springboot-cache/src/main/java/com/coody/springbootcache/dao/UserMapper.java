package com.coody.springbootcache.dao;

import com.coody.springbootcache.entity.User;

/**
 * @Classname UserDao
 * @Description TODO
 * @Author lw
 * @Date 2020-03-05 16:28
 */
public interface UserMapper {

    User queryUserById(int id);
}
