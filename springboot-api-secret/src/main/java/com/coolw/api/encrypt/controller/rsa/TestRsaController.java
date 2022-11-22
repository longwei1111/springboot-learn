package com.coolw.api.encrypt.controller.rsa;

import com.coolw.api.encrypt.annotation.Security;
import com.coolw.api.encrypt.model.OutsideResponse;
import com.coolw.api.encrypt.model.UserInfo;
import com.coolw.api.encrypt.model.UserCreateReq;
import com.coolw.api.encrypt.util.OutsideResponseUtils;
import com.coolw.common.api.BaseResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 测试RSA非对称加密，对接口请求和响应进行加解密
 *
 * @author coolw
 * @date 2022/11/16 9:27
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/rsa")
public class TestRsaController {

    @ApiOperation("获取请求,然后模拟调用(/user/create):三方请求方->我们")
    @Security
    @GetMapping("/get")
    public OutsideResponse<UserCreateReq> generateRsaRequest() {
        UserCreateReq req = new UserCreateReq("15000112233");
        return OutsideResponseUtils.convert(BaseResponse.success(req));
    }
    
    @ApiOperation("模拟三方请求方->我们")
    @Security
    @PostMapping("/user/create")
    public OutsideResponse<UserInfo> createUser(@RequestBody @Validated UserCreateReq req) {
        log.info("req:{}", req);
        String mobile = req.getMobile();
        String defaultName = String.format("用户信息%s", mobile);
        
        UserInfo user = new UserInfo(2, new Date());
        user.setMobile(mobile);
        user.setName(defaultName);
        return OutsideResponseUtils.convert(BaseResponse.success(user));
    }
}
