package com.coody.springbootlistener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Classname MyHttpSessionListener
 * @Description 使用HttpSessionListener统计在线用户数的监听器
 * @Author lw
 * @Date 2020-02-25 14:56
 */
@Slf4j
@Component
public class MyHttpSessionListener implements HttpSessionListener {

    /**
     * 记录在线的人数
     */
    public Integer count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("用户上线了");
        count++;
        se.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("用户下线了");
        count--;
        se.getSession().getServletContext().setAttribute("count", count);
    }
}
