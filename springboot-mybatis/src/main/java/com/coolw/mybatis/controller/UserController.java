package com.coolw.mybatis.controller;

import com.coolw.common.api.Response;
import com.coolw.mybatis.domain.req.UpdateStatusReq;
import com.coolw.mybatis.entity.UserEntity;
import com.coolw.mybatis.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-25 11:38
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Response<Integer> addUser(@RequestBody UserEntity userEntity) {
        return new Response().success(userService.addUser(userEntity));
    }

    @GetMapping("/userName/{userName}")
    public Response<List<UserEntity>> getUserListByUserName(@PathVariable String userName) {
        return new Response<>().success(userService.getUserListByUserName(userName));
    }

    @GetMapping("/id/{id}")
    public Response<UserEntity> getUserById(@PathVariable Long id) {
        return new Response<>().success(userService.getUserById(id));
    }

    @GetMapping("/id/{id}/userName/{userName}")
    public Response<UserEntity> getUserByIdAndUserName(@PathVariable Long id, @PathVariable String userName) {
        return new Response<>().success(userService.getUserByIdAndUserName(id, userName));
    }

    @PostMapping("/updateStatus")
    public Response<Integer> updateStatus(@Validated @RequestBody UpdateStatusReq req) {
        return new Response<>().success(userService.updateUserStatusByUserNo(req.getUserNo(), req.getUserStatus()));
    }
}
