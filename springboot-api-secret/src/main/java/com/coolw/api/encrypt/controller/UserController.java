package com.coolw.api.encrypt.controller;

import com.coolw.api.encrypt.annotation.DecryptRequest;
import com.coolw.api.encrypt.annotation.EncryptResponse;
import com.coolw.api.encrypt.domain.req.UserSaveReq;
import com.coolw.api.encrypt.domain.resp.UserInfoResp;
import com.coolw.common.api.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/11/16 9:27
 * @since 1.0
 */
@EncryptResponse
@DecryptRequest
@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/list")
    public BaseResponse<List<UserInfoResp>> listUser() {
        List<UserInfoResp> userList = new ArrayList<>();
        userList.add(new UserInfoResp(1, "15000994412", "zhangsan", new Date()));
        userList.add(new UserInfoResp(2, "13817708142", "lisi", new Date()));
        return BaseResponse.success(userList);
    }
    
    @PostMapping("/save")
    public BaseResponse<UserInfoResp> save(@RequestBody UserSaveReq req) {
        UserInfoResp resp = new UserInfoResp();
        resp.setName(req.getName());
        resp.setMobile(req.getMobile());
        resp.setId(3);
        resp.setRegisterTime(new Date());
        return BaseResponse.success(resp);
    }
}
