package com.coolw.mybatis.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.mybatis.dto.req.UpdateUserStatusReq;
import com.coolw.mybatis.dto.req.UserSaveReq;
import com.coolw.mybatis.entity.UserEntity;
import com.coolw.mybatis.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping("/save")
    public BaseResponse<Integer> saveUser(@Validated @RequestBody UserSaveReq req) {
        return BaseResponse.success(userService.save(req));
    }

    @PostMapping("/saveBatch")
    public BaseResponse<Integer> saveBatch(@RequestBody List<UserSaveReq> reqs) {
        return BaseResponse.success(userService.saveBatch(reqs));
    }
    
    @GetMapping("/userName/{userName}")
    public BaseResponse<List<UserEntity>> getUserListByUserName(@PathVariable String userName) {
        return BaseResponse.success(userService.getUserListByUserName(userName));
    }

    @GetMapping("/id/{id}")
    public BaseResponse<UserEntity> getUserById(@PathVariable Long id) {
        return BaseResponse.success(userService.getUserById(id));
    }

    @PostMapping("/listByIds")
    public BaseResponse<List<UserEntity>> getUserListByIds(@RequestBody List<Long> ids) {
        return BaseResponse.success(userService.listByIds(ids));
    }

    @GetMapping("/mobile/{mobile}/userName/{userName}")
    public BaseResponse<UserEntity> getUserByIdAndUserName(@PathVariable String mobile, @PathVariable String userName) {
        return BaseResponse.success(userService.getUserByMobileAndName(mobile, userName));
    }

    @PostMapping("/updateStatus")
    public BaseResponse<Integer> updateStatus(@Validated @RequestBody UpdateUserStatusReq req) {
        return BaseResponse.success(userService.updateUserStatusByUserNo(req.getUserNo(), req.getUserStatus()));
    }
    
    @ApiOperation("分页查询用户信息")
    @GetMapping("/pageList")
    public BaseResponse<PageInfo<UserEntity>> pageList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return BaseResponse.success(userService.pageList(pageNum, pageSize));
    }
    
}
