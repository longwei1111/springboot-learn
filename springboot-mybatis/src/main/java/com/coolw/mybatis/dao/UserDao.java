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
     * 保存用户
     */
    int save(UserEntity user);

    /**
     * 保存用户
     */
    int saveBatch(@Param("userList") List<UserEntity> userList);

    /**
     * 根据姓名获取用户信息
     */
    List<UserEntity> getListByUserName(String userName);

    /**
     * 使用注解和xml结合。根据主键id和姓名获取用户信息
     */
    @Select("select * from coo_user where mobile = #{mobile} and user_name = #{userName}")
    @ResultMap("Base_Result_Map")
    UserEntity getUserByMobileAndName(@Param("mobile") String mobile, @Param("userName") String userName);

    /**
     * 使用注解，结果映射。根据主键id获取用户信息
     */
    @Select("select * from coo_user where id = #{id}")
    @Results({
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "password", property = "password"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "address", property = "address"),
            @Result(column = "user_status", property = "userStatus")
    })
    UserEntity getUserById(long id);
    
    List<UserEntity> listByIds(@Param("ids") List<Long> ids);

    int updateUserStatusByUserNo(@Param("userNo") String userNo, @Param("userStatus") String userStatus);
    
    List<UserEntity> listAll();
}
