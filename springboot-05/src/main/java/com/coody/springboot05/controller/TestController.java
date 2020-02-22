package com.coody.springboot05.controller;

import com.coody.springboot05.common.JsonResult;
import com.coody.springboot05.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-22 20:05
 */
@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2 在线接口文档")
public class TestController {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") Integer id) {
        User user = new User(id, "longwei", "123456");
        return new JsonResult<>(user);
    }
}
