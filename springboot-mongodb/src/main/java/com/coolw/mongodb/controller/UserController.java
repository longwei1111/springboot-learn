package com.coolw.mongodb.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.mongodb.entity.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-27 15:15
 */
@RestController
public class UserController {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 新增用户信息
     */
    @PostMapping("/user/add")
    public BaseResponse<User> addUser(User user) {
        User resultUser = mongoTemplate.insert(user, "user");
        return BaseResponse.success(resultUser);
    }

    /**
     * 根据id查询用户信息
     */
    @PostMapping("/user/query/{id}")
    public BaseResponse<User> getUser(@PathVariable Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query, User.class, "user");
        return BaseResponse.success(user);
    }

    /**
     * 更新用户信息
     */
    @PostMapping("/user/update")
    public BaseResponse<UpdateResult> update(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getId()));

        Update update = new Update();
        update.set("password", user.getPassword());

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, "user");
        return BaseResponse.success(updateResult);
    }

    /**
     * 获取用户信息列表
     */
    @GetMapping("/user/getAll")
    public BaseResponse<List<User>> getAllUser() {
        List<User> userList = mongoTemplate.findAll(User.class, "user");
        return BaseResponse.success(userList);
    }

    /**
     * 根据id删除用户信息
     */
    @DeleteMapping("/user/delete/{id}")
    public BaseResponse<DeleteResult> deleteUser(@PathVariable Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        DeleteResult deleteResult = mongoTemplate.remove(query, User.class, "user");
        return BaseResponse.success(deleteResult);
    }
}
