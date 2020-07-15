package com.coody.springboot.mongodb.controller;

import com.coody.springboot.mongodb.entity.User;
import com.coody.springboot.mongodb.result.JsonResult;
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
 * @Classname MongoController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 15:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public JsonResult<User> addUser(User user) {
        User resultUser = mongoTemplate.insert(user, "user");
        return new JsonResult<>(resultUser);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @PostMapping("/query/{id}")
    public JsonResult<User> getUser(@PathVariable Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query, User.class, "user");
        return new JsonResult<>(user);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    public JsonResult<UpdateResult> update(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getId()));

        Update update = new Update();
        update.set("password", user.getPassword());

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, "user");
        return new JsonResult<>(updateResult);
    }

    /**
     * 获取用户信息列表
     *
     * @return
     */
    @GetMapping("/getAll")
    public JsonResult<List<User>> getAllUser() {
        List<User> userList = mongoTemplate.findAll(User.class, "user");
        return new JsonResult<>(userList);
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public JsonResult<DeleteResult> deleteUser(@PathVariable Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        DeleteResult deleteResult = mongoTemplate.remove(query, User.class, "user");
        return new JsonResult(deleteResult);
    }
}
