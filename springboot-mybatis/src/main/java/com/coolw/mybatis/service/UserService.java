package com.coolw.mybatis.service;

import com.coolw.mybatis.entity.User;

import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-03-05 15:51
 */
public interface UserService {

    int addUser(User user);

    List<User> getUserListByUserName(String userName);

    User getUserById(long id);

    User getUserByIdAndUserName(long id, String userName);

    int updateUserStatusByUserNo(String userNo, String userStatus);
}
