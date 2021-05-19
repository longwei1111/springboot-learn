package com.coolw.transaction.service.impl;

import com.coolw.transaction.entity.User;
import com.coolw.transaction.service.UserService;
import com.coolw.transaction.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @Description Spring Boot 默认的事务规则是遇到运行异常（RuntimeException）和程序错误（Error）才会回滚
 * @Author coolw
 * @Date 2020-02-25 11:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /**
     * RuntimeException异常被捕获到，事务回滚
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Integer insertUser(User user) {
        log.info("新增用户信息，user={}", user);

        Integer count = userMapper.insertUser(user);

        // 手动抛出RuntimeException，事务回滚
        throw new RuntimeException();

        //return count;
    }

    /**
     * 常见问题1：SQLException异常没有被捕获到，事务不回滚
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Integer insertUser_1(User user) throws Exception {
        log.info("新增用户信息，user={}", user);

        Integer count = userMapper.insertUser(user);

        // 手动抛出SQLException，事务不回滚
        throw new SQLException("数据库异常");

        //return count;
    }

    /**
     * 常见问题2：异常被吃掉
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Integer insertUser_2(User user) {
        log.info("新增用户信息，user={}", user);

        Integer count = 0;
        try {
            count = userMapper.insertUser(user);

            // 手动抛出SQLException，事务不回滚
            throw new SQLException("数据库异常");
        } catch (Exception e) {
            // 异常逻辑处理
        }

        return count;
    }

    /**
     * 常见问题3：事务的范围。事务的范围比锁的范围大，可能导致数据不正确
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Integer insertUser_3(User user) {
        log.info("新增用户信息，user={}", user);

        // 具体的业务处理......

        return userMapper.insertUser(user);
    }
}
