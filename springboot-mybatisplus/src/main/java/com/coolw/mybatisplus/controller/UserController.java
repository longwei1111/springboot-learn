package com.coolw.mybatisplus.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coolw.mybatisplus.dto.UserExcel;
import com.coolw.mybatisplus.dto.UserReportReq;
import com.coolw.mybatisplus.entity.UserEntity;
import com.coolw.mybatisplus.service.UserService;
import com.coolw.mybatisplus.util.ExcelUtils;
import com.coolw.mybatisplus.util.PageResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:19
 * @since 1.0
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public boolean add(@RequestBody UserEntity entity) {
        return userService.save(entity);
    }

    @GetMapping("/list")
    public List<UserEntity> list() {
        return userService.list();
    }

    @GetMapping("/list/{userName}")
    public List<UserEntity> listByName(@PathVariable String userName) {
        return userService.list(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getUserName, userName));
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
