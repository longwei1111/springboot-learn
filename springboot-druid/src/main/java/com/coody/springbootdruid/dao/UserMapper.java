package com.coody.springbootdruid.dao;

import com.coody.springbootdruid.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> getList();

    User getById(int id);
}
