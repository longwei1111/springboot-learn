package com.coolw.mybatis.service;

import com.coolw.mybatis.entity.UserEntity;

import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-03-05 15:51
 */
public interface UserService {

    int addUser(UserEntity user);

    List<UserEntity> getUserListByUserName(String userName);

    UserEntity getUserById(long id);

    UserEntity getUserByIdAndUserName(long id, String userName);

    int updateUserStatusByUserNo(String userNo, String userStatus);
}
