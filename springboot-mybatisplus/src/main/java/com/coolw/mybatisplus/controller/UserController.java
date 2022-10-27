package com.coolw.mybatisplus.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coolw.mybatisplus.domain.excel.UserExcel;
import com.coolw.mybatisplus.domain.req.UserReportReq;
import com.coolw.mybatisplus.domain.req.UserSaveReq;
import com.coolw.mybatisplus.entity.UserEntity;
import com.coolw.mybatisplus.mapper.UserMapper;
import com.coolw.mybatisplus.service.UserService;
import com.coolw.mybatisplus.util.ExcelUtils;
import com.coolw.mybatisplus.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:19
 * @since 1.0
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/save")
    public boolean save(@RequestBody UserSaveReq req) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(req, user);

        Map<String, Object> extMap = new HashMap<>();
        extMap.put("custId", "12312321");
        user.setExtMap(extMap);

        log.info("before user:{}", user);
        List<UserEntity> list = new ArrayList<>();
        list.add(user);
        boolean result = userService.saveBatch(list);
        log.info("after user-list:{}", list);
        return result;
    }

    @GetMapping("/listAll")
    public List<UserEntity> list() {
        return userService.list();
    }

    @GetMapping("/list/{userName}")
    public List<UserEntity> listByName(@PathVariable String userName) {
        return userService.list(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getUserName, userName));
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable String id) {
        // 一级缓存，默认开启，作用于同一个sqlSession中
        /*SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.selectById(id);
        userMapper.selectById(id);
        userMapper.selectById(id);*/
        
        // 二级缓存，需要手动开启，作用于同一个namespace中
        userMapper.selectById(id);
        userMapper.selectById(id);
        userMapper.selectById(id);
        return null;
    }
    
    @PostMapping("/pageList")
    public PageResult<UserEntity> pageList(@RequestBody UserReportReq req) {
        return userService.pageList(req);
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody UserReportReq req) throws IOException {
        // 用户报表数据
        List<UserExcel> data = userService.export(req);
        // 文件名称,防止中文乱码
        String fileName = URLEncoder.encode("用户信息_" + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT) + ".xlsx", "UTF-8");
        // Excel页签名称
        String sheetName = "用户信息";
        // 写入数据
        ExcelUtils.writeExcel(response, fileName, sheetName, data, UserExcel.class);
    }

}
