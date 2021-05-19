package com.coolw.listener.event;

import com.coolw.listener.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * @Description 自定义事件
 * @Author coolw
 * @Date 2020-02-25 15:57
 */
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
