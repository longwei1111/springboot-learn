package com.coody.springboot.druid.dao;

import com.coody.springboot.druid.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> getList();

    User getById(int id);
}
