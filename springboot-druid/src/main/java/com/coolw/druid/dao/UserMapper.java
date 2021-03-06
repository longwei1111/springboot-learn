package com.coolw.druid.dao;

import com.coolw.druid.entity.User;

import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-03-05 15:51
 */
public interface UserMapper {

    List<User> getList();

    User getById(int id);
}
