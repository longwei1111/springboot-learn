package com.coody.springbootcache.service.impl;

import com.coody.springbootcache.dao.UserMapper;
import com.coody.springbootcache.entity.User;
import com.coody.springbootcache.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author lw
 * @Date 2020-03-05 15:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userDao;

    /**
     * @Cacheable把方法返回值添加到Ehcache缓存中
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Cacheable(value = "userInfo", key = "#id")
    public User queryUserById(int id) {
        User user = userDao.queryUserById(id);
        return user;
    }

}
