package com.coody.springboot.thymeleaf.controller;

import com.coody.springboot.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ThymeleafController
 * @Description
 *          在使用模板引擎时，Controller 层就不能用 @RestController 注解了，
 *          因为在使用 thymeleaf 模板时，返回的是视图文件名，比如上面的 Controller 中是返回到 index.html 页面，
 *          如果使用 @RestController 的话，会把 index 当作 String 解析了，直接返回到页面了，而不是去找 index.html 页面
 * @Author lw
 * @Date 2020-02-24 14:48
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/test404")
    public String test404() {
        return "index";
    }

    @RequestMapping("/test500")
    public String test500() {
        int i = 1 / 0;
        return "index";
    }

    /**
     * Thymeleaf 中处理对象
     *
     * @param model
     * @return
     */
    @GetMapping("/getUser")
    public String getUser(Model model) {
        User user = new User(1, "zhangsan", "123456");
        model.addAttribute("user", user);
        return "user/user";
    }

    /**
     * Thymeleaf 中处理 List
     *
     * @param model
     * @return
     */
    @GetMapping("/getUserList")
    public String getUserList(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "zhangsan", "123456"));
        userList.add(new User(1, "lisi", "654321"));
        model.addAttribute("userList", userList);
        return "user/userList";
    }
}
