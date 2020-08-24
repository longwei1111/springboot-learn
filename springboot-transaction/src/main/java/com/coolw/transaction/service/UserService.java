package com.coolw.transaction.service;

import com.coolw.transaction.entity.User;

/**
 * @Classname UserService
 * @Description
 * @Author lw
 * @Date 2020-02-25 11:36
 */
public interface UserService {

    Integer insertUser(User user);

    Integer insertUser_1(User user) throws Exception;

    Integer insertUser_2(User user);

    Integer insertUser_3(User user);
}
