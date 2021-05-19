package com.coolw.listener.controller;

import com.coolw.listener.entity.User;
import com.coolw.listener.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 14:47
 */
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @GetMapping("/listener/getUser")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        User user = (User) application.getAttribute("user");
        return user;
    }

    /**
     * 获取当前在线人数，该方法有bug
     * 当关闭一个浏览器访问时，数据不减1
     *
     * @param request
     * @return
     */
    @GetMapping("/listener/getTotalUser")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    /**
     * 获取当前在线人数
     *
     * @param request
     * @return
     */
    @GetMapping("/listener/total")
    public String getTotal(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            // 把session记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            // 设置cookie有效期为2天
            cookie.setMaxAge(48 * 60 * 60);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/listener/request")
    public String getRequestInfo(HttpServletRequest request) {
        log.info("requestListener中的初始化的name为：{}", request.getAttribute("name"));
        return "success";
    }

    @GetMapping("/listener/publish")
    public User publish() {
        return userService.getUser1();
    }
}
