package com.coolw.mybatis.service.impl;

import com.coolw.mybatis.dao.UserDao;
import com.coolw.mybatis.entity.User;
import com.coolw.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 11:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        log.info("新增客户信息 user={}", user);
        return userDao.insert(user);
    }

    @Override
    public List<User> getUserListByUserName(String userName) {
        log.info("根据客户名称获取客户信息 userName={}", userName);
        return userDao.getListByUserName(userName);
    }

    @Override
    public User getUserByIdAndUserName(long id, String userName) {
        log.info("根据主键id和客户姓名获取客户信息 id={},userName={}", id, userName);
        return userDao.getUserByIdAndUserName(id, userName);
    }

    @Override
    public User getUserById(long id) {
        log.info("根据主键id获取客户信息 id={}", id);
        return userDao.getUserById(id);
    }

    @Override
    public int updateUserStatusByUserNo(String userNo, String userStatus) {
        log.info("根据用户号更新用户状态 userNo={},userStatus={}", userNo, userStatus);
        return userDao.updateUserStatusByUserNo(userNo, userStatus);
    }
}
