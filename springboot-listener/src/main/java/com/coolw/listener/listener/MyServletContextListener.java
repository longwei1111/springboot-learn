package com.coolw.listener.listener;

import com.coolw.listener.service.UserService;
import com.coolw.listener.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * @Classname MyServletContextListener
 * @Description 使用ApplicationListener来初始化一些数据到application域中的监听器
 * @Author lw
 * @Date 2020-02-25 14:49
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 获取application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取service
        UserService userService = applicationContext.getBean(UserService.class);
        // 获取用户信息
        User user = userService.getUser();

        // 获取application域对象，将用户信息放到application重
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user", user);
    }
}
