package com.coolw.rocketmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.coolw.common.api.BaseResponse;
import com.coolw.rocketmq.constant.MqConstants;
import com.coolw.rocketmq.dto.MqMessage;
import com.coolw.rocketmq.dto.UserInfo;
import com.coolw.rocketmq.service.RocketMqService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coolw
 * @date 2022/12/7 10:18
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RocketMqService rocketMqService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public BaseResponse register() {
        UserInfo userInfo = new UserInfo("zhangsan", "15000110022", 20);

        MqMessage<UserInfo> mqMessage = new MqMessage(MqConstants.USER_TOPIC, MqConstants.USER_TAG_REGISTER);
        mqMessage.setContent(userInfo);
        rocketMqService.asynSend(mqMessage);
        return BaseResponse.success();
    }
    
    @ApiOperation("用户修改")
    @PostMapping("/modify")
    public BaseResponse modify() {
        UserInfo userInfo = new UserInfo("zhangsan", "15000994455", 21);
        
        MqMessage<UserInfo> mqMessage = new MqMessage(MqConstants.USER_TOPIC, MqConstants.USER_TAG_MODIFY);
        mqMessage.setContent(userInfo);
        rocketMqService.asynSend(mqMessage);
        return BaseResponse.success();
    }
}
