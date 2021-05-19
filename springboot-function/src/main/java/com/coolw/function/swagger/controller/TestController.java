package com.coolw.function.swagger.controller;

import com.coolw.common.api.Response;
import com.coolw.function.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-22 20:05
 */
@RestController
@Api(value = "Swagger2 在线接口文档")
public class TestController {

    /**
     * @Api 注解用于类上，表示标识这个类是 swagger 的资源
     * @ApiOperation 注解用于方法，表示一个 http 请求的操作
     * @ApiParam 注解用于参数上，用来标明参数信息
     */

    @GetMapping("/swagger/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public Response<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") Integer id) {
        User user = new User(id, "zhangsan", "123456");
        return new Response().success(user);
    }
}
