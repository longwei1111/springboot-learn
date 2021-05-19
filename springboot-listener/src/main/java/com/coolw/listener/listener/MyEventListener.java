package com.coolw.listener.listener;

import com.coolw.listener.entity.User;
import com.coolw.listener.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description 自定义监听器，监听MyEvent事件
 * @Author coolw
 * @Date 2020-02-25 16:01
 */
@Slf4j
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 从事件中获取用户信息
        User user = myEvent.getUser();
        log.info("用户名：{}", user.getUsername());
        log.info("用户密码：{}", user.getPassword());
    }
}
