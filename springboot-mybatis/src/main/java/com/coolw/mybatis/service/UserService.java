package com.coolw.mybatis.service;

import com.coolw.mybatis.dto.req.UserSaveReq;
import com.coolw.mybatis.entity.UserEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-03-05 15:51
 */
public interface UserService {

    int save(UserSaveReq req);

    int saveBatch(List<UserSaveReq> reqs);

    List<UserEntity> getUserListByUserName(String userName);

    UserEntity getUserById(Long id);

    List<UserEntity> listByIds(List<Long> ids);

    UserEntity getUserByMobileAndName(String mobile, String userName);

    int updateUserStatusByUserNo(String userNo, String userStatus);
    
    PageInfo<UserEntity> pageList(Integer pageNum, Integer pageSize);
}
