package com.coolw.mybatis.controller;

import com.coolw.common.api.Response;
import com.coolw.mybatis.entity.User;
import com.coolw.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 11:38
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/add")
    public Response<Integer> addUser(@RequestBody User userEntity) {
        return new Response().success(userService.addUser(userEntity));
    }

    @GetMapping("/user/getUserByUserName/{userName}")
    public Response<List<User>> getUserListByUserName(@PathVariable String userName) {
        return new Response<>().success(userService.getUserListByUserName(userName));
    }

    @GetMapping("/user/getUserById/{id}")
    public Response<User> getUserById(@PathVariable long id) {
        return new Response<>().success(userService.getUserById(id));
    }

    @GetMapping("/user/{id}/{userName}")
    public Response<User> getUserByIdAndUserName(@PathVariable long id, @PathVariable String userName) {
        return new Response<>().success(userService.getUserByIdAndUserName(id, userName));
    }

    @PostMapping("/user/updateStatus")
    public Response<Integer> updateUserStatusById(@RequestParam String userNo, @RequestParam String userStatus) {
        return new Response<>().success(userService.updateUserStatusByUserNo(userNo, userStatus));
    }
}
