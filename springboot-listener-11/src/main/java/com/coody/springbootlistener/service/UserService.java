package com.coody.springbootlistener.service;

import com.coody.springbootlistener.entity.User;
import com.coody.springbootlistener.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserService
 * @Description TODO
 * @Author lw
 * @Date 2020-02-25 14:45
 */
@Service
public class UserService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 获取用户信息
     *
     * @return
     */
    public User getUser() {
        return new User(1, "zhangsan", "123456789");
    }

    /**
     * 发布事件
     */
    public User getUser1 (){
        User user = new User(666, "zhangsan", "123456");
        // 发布事件
        MyEvent myEvent = new MyEvent(this, user);
        applicationContext.publishEvent(myEvent);
        return user;
    }
}
