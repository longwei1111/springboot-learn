package com.coody.springboot.mvc.controller;

import com.coody.springboot.mvc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname TestController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-22 19:22
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * @RequestMapping 请求映射地址
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String testGet() {
        return "success";
    }

    /**
     * @PathVariable 获取url参数
     *
     * 比如url为：http://localhost:8080/user/1
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id) {
        log.info("获取到的id={}", id);
        return "success";
    }

    @GetMapping("/user/{idd}/{name}")
    public String testPathVariable1(@PathVariable(value = "idd") Integer id, @PathVariable String name) {
        log.info("获取到的id={}, name={}", id, name);
        return "success";
    }

    /**
     * @RequestParam 获取请求参数
     * 比如url为：http://localhost:8080/user?idd=1
     *
     * @param id
     * @return
     */
    @GetMapping("/user")
    public String testRequestParam(@RequestParam(value = "idd", required = false) Integer id) {
        log.info("获取到的id={}", id);
        return "success";
    }

    /**
     * 多个属性表单请求
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/form1")
    public String testForm1(@RequestParam String username, @RequestParam String password) {
        log.info("获取到的username={},password={}", username, password);
        return "success";
    }

    /**
     * 实体类对象请求
     *
     * @param user
     * @return
     */
    @PostMapping("/form2")
    public String testForm2(User user) {
        log.info("获取到的username={},password={}", user.getUsername(), user.getPassword());
        return "success";
    }

    /**
     * 实体类对象-json数据请求
     * @RequestBody 用于接收前端传来的实体(json)
     *
     * @param user
     * @return
     */
    @PostMapping("/userInfo")
    public String testRequestBody(@RequestBody User user) {
        log.info("获取到的username={},password={}", user.getUsername(), user.getPassword());
        return "success";
    }
}
