package com.coolw.mybatis.dao;

import com.coolw.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-03-05 15:51
 */
public interface UserDao {

    /**
     * 新增用户
     */
    int insert(UserEntity user);

    /**
     * 根据姓名获取用户信息
     */
    List<UserEntity> getListByUserName(String userName);

    /**
     * 使用注解和xml结合。根据主键id和姓名获取用户信息
     */
    @Select("select * from coo_user where id = #{id} and user_name = #{userName}")
    @ResultMap("Base_Result_Map")
    UserEntity getUserByIdAndUserName(@Param("id") long id, @Param("userName") String userName);

    /**
     * 使用注解，结果映射。根据主键id获取用户信息
     */
    @Select("select * from coo_user where id = #{id}")
    @Results({
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "password", property = "password"),
            @Result(column = "mobile_no", property = "mobileNo"),
            @Result(column = "address", property = "address"),
            @Result(column = "user_status", property = "userStatus")
    })
    UserEntity getUserById(long id);

    int updateUserStatusByUserNo(@Param("userNo") String userNo, @Param("userStatus") String userStatus);
}
