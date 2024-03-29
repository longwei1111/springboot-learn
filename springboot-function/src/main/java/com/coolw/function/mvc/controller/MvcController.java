package com.coolw.function.mvc.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.function.mvc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-22 19:22
 */
@Slf4j
@RestController
public class MvcController {

    /**
     * @RequestMapping 请求映射地址
     */
    @RequestMapping(value = "/mvc/get", method = RequestMethod.GET)
    public String testGet() {
        return "success";
    }

    /**
     * @PathVariable 获取url参数
     */
    @GetMapping("/mvc/user/{id}")
    public BaseResponse testPathVariable(@PathVariable Integer id) {
        log.info("获取到的id={}", id);
        return BaseResponse.success();
    }

    @GetMapping("/mvc/user/{idd}/{name}")
    public BaseResponse testPathVariable1(@PathVariable(value = "idd") Integer id, @PathVariable String name) {
        log.info("获取到的id={}, name={}", id, name);
        return BaseResponse.success();
    }

    /**
     * @RequestParam 获取请求参数
     */
    @GetMapping("/mvc/user")
    public BaseResponse testRequestParam(@RequestParam(value = "idd", required = false) Integer id) {
        log.info("获取到的id={}", id);
        return BaseResponse.success();
    }

    /**
     * 多个属性表单请求
     */
    @PostMapping("/mvc/form1")
    public BaseResponse testForm1(@RequestParam String username, @RequestParam String password) {
        log.info("获取到的username={},password={}", username, password);
        return BaseResponse.success();
    }

    /**
     * 实体类对象请求
     */
    @PostMapping("/mvc/form2")
    public BaseResponse testForm2(User user) {
        log.info("获取到的username={},password={}", user.getUsername(), user.getPassword());
        return BaseResponse.success();
    }

    /**
     * 实体类对象-json数据请求
     * @RequestBody 用于接收前端传来的实体(json)
     */
    @PostMapping("/mvc/userInfo")
    public BaseResponse testRequestBody(@RequestBody User user) {
        log.info("获取到的username={},password={}", user.getUsername(), user.getPassword());
        return BaseResponse.success();
    }
}
