package com.coolw.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coolw.mybatisplus.dto.UserExcel;
import com.coolw.mybatisplus.dto.UserReportReq;
import com.coolw.mybatisplus.entity.UserEntity;
import com.coolw.mybatisplus.mapper.UserMapper;
import com.coolw.mybatisplus.service.UserService;
import com.coolw.mybatisplus.util.PageResult;
import com.coolw.mybatisplus.util.PageUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:20
 * @since 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageResult<UserEntity> pageList(UserReportReq req) {
        Page<UserEntity> page = new Page<>();
        if (req.getPageNum() != null && req.getPageSize() != null) {
            page.setCurrent(req.getPageNum());
            page.setSize(req.getPageSize());
        }
        IPage<UserEntity> pageSource = userMapper.queryPage(page, req);
        return PageUtils.convertPageResult(pageSource);
    }

    @Override
    public List<UserExcel> export(UserReportReq req) {
        List<UserEntity> users = pageList(req).getData();
        if (CollectionUtils.isEmpty(users)) {
            return new ArrayList<>();
        }

        List<UserExcel> excelDataList = new ArrayList<>(users.size());
        users.forEach(u -> {
            UserExcel excelData = new UserExcel();
            BeanUtils.copyProperties(u, excelData);
            excelDataList.add(excelData);
        });
        return excelDataList;
    }

}
