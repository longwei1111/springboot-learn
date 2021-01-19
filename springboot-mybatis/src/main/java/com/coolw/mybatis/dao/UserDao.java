package com.coolw.mybatis.dao;

import com.coolw.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Classname UserDao
 * @Description
 * @Author lw
 * @Date 2020-03-05 15:51
 */
public interface UserDao {

    /**
     * 新增用户
     */
    int insert(User user);

    /**
     * 根据姓名获取用户信息
     */
    List<User> getListByUserName(String userName);

    /**
     * 使用注解和xml结合。根据主键id和姓名获取用户信息
     *
     * @param id
     * @param userName
     * @return UserEntity
     */
    @Select("select * from coo_user where id = #{id} and user_name = #{userName}")
    @ResultMap("Base_Result_Map")
    User getUserByIdAndUserName(@Param("id") long id, @Param("userName") String userName);

    /**
     * 使用注解，结果映射。根据主键id获取用户信息
     *
     * @param id
     * @return UserEntity
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
    User getUserById(long id);

    int updateUserStatusByUserNo(@Param("userNo") String userNo, @Param("userStatus") String userStatus);
}
