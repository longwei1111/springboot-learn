package com.coody.springboot.mybatis.dao;

import com.coody.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Classname UserMapper
 * @Description
 * @Author lw
 * @Date 2020-03-05 15:51
 */
public interface UserMapper {

    /**
     * 使用xml。根据姓名获取用户信息
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 使用注解，单个参数。根据主键id获取用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    /**
     * 使用注解和xml结合，多个参数。根据主键id和姓名获取用户信息
     *
     * @param id
     * @param username
     * @return
     */
    @Select("select * from user where id = #{id} and user_name = #{name}")
    @ResultMap("BaseResultMap")
    User getUserByIdAndName(@Param("id") int id, @Param("name") String username);

    /**
     * 使用注解，结果映射。根据主键id获取用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "user_name", property = "username"),
            @Result(column = "pass_word", property = "password")
    })
    User getUserById_1(int id);
}
