package com.coolw.mybatis.service.impl;

import cn.hutool.core.util.IdUtil;
import com.coolw.mybatis.converter.UserConvert;
import com.coolw.mybatis.dao.UserDao;
import com.coolw.mybatis.dto.req.UserSaveReq;
import com.coolw.mybatis.entity.UserEntity;
import com.coolw.mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 11:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserConvert userConvert;
    @Autowired
    private UserDao userDao;

    @Override
    public int save(UserSaveReq req) {
        log.info("新增客户信息 req={}", req);
        UserEntity user = userConvert.toUserEntity(req);
        user.setUserNo(IdUtil.fastSimpleUUID());
        return userDao.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveBatch(List<UserSaveReq> reqs) {
        List<UserEntity> userList = reqs.stream().map(r -> userConvert.toUserEntity(r)).collect(Collectors.toList());
        userList.forEach(u -> u.setUserNo(IdUtil.fastSimpleUUID()));
        return userDao.saveBatch(userList);
    }

    @Override
    public List<UserEntity> getUserListByUserName(String userName) {
        log.info("根据客户名称获取客户信息 userName={}", userName);
        return userDao.getListByUserName(userName);
    }

    @Override
    public UserEntity getUserByMobileAndName(String mobile, String userName) {
        log.info("根据主键手机号和姓名获取客户信息 mobile={},userName={}", mobile, userName);
        return userDao.getUserByMobileAndName(mobile, userName);
    }

    @Override
    public UserEntity getUserById(Long id) {
        log.info("根据主键id获取客户信息 id={}", id);
        return userDao.getUserById(id);
    }

    @Override
    public List<UserEntity> listByIds(List<Long> ids) {
        return userDao.listByIds(ids);
    }

    @Override
    public int updateUserStatusByUserNo(String userNo, String userStatus) {
        log.info("根据用户号更新用户状态 userNo={},userStatus={}", userNo, userStatus);
        return userDao.updateUserStatusByUserNo(userNo, userStatus);
    }

    @Override
    public PageInfo<UserEntity> pageList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userList = userDao.listAll();
        return new PageInfo<>(userList);
    }
}
