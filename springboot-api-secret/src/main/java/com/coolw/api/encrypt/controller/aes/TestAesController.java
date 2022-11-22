package com.coolw.api.encrypt.controller.aes;

import com.coolw.api.encrypt.annotation.DecryptRequest;
import com.coolw.api.encrypt.annotation.EncryptResponse;
import com.coolw.api.encrypt.model.UserInfo;
import com.coolw.common.api.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 测试AES对称加密，对接口请求和响应进行加解密
 *
 * @author coolw
 * @date 2022/11/16 9:27
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/aes")
public class TestAesController {
    
    @EncryptResponse
    @GetMapping("/getUser")
    public BaseResponse<UserInfo> getUser() {
        UserInfo user = new UserInfo(1, "15000994412", "zhangsan", new Date());
        return BaseResponse.success(user);
    }
    
    @DecryptRequest
    @PostMapping("/addUser")
    public BaseResponse<UserInfo> addUser(@RequestBody UserInfo user) {
        log.info("user:{}", user);
        return BaseResponse.success(user);
    }
}
