package com.coolw.listener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description 使用ServletRequestListener获取访问信息
 * @Author coolw
 * @Date 2020-02-25 15:45
 */
@Slf4j
@Component
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        log.info("session id为：{}", request.getRequestedSessionId());
        log.info("request url为：{}", request.getRequestURI());

        request.setAttribute("name", "liudehua");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request end");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        log.info("request域中保存的name值为：{}", request.getAttribute("name"));
    }

}

