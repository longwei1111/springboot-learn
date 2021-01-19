package com.coolw.mybatis.controller;

import com.coolw.common.api.ResultResponse;
import com.coolw.mybatis.entity.User;
import com.coolw.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserController
 * @Description
 * @Author lw
 * @Date 2020-02-25 11:38
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/add")
    public ResultResponse<Integer> addUser(@RequestBody User userEntity) {
        return new ResultResponse().success(userService.addUser(userEntity));
    }

    @GetMapping("/user/getUserByUserName/{userName}")
    public ResultResponse<List<User>> getUserListByUserName(@PathVariable String userName) {
        return new ResultResponse<>().success(userService.getUserListByUserName(userName));
    }

    @GetMapping("/user/getUserById/{id}")
    public ResultResponse<User> getUserById(@PathVariable long id) {
        return new ResultResponse<>().success(userService.getUserById(id));
    }

    @GetMapping("/user/{id}/{userName}")
    public ResultResponse<User> getUserByIdAndUserName(@PathVariable long id, @PathVariable String userName) {
        return new ResultResponse<>().success(userService.getUserByIdAndUserName(id, userName));
    }

    @PostMapping("/user/updateStatus")
    public ResultResponse<Integer> updateUserStatusById(@RequestParam String userNo, @RequestParam String userStatus) {
        return new ResultResponse<>().success(userService.updateUserStatusByUserNo(userNo, userStatus));
    }
}
