package com.coolw.transaction.dao;

import com.coolw.transaction.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Classname UserMapper
 * @Description
 * @Author lw
 * @Date 2020-02-25 11:28
 */
public interface UserMapper {

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    @Select("insert into user (user_name, pass_word) values (#{username}, #{password})")
    Integer insertUser(User user);
}
