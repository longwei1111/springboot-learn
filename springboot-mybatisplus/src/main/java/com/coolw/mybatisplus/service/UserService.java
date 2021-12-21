package com.coolw.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coolw.mybatisplus.dto.UserExcel;
import com.coolw.mybatisplus.dto.UserReportReq;
import com.coolw.mybatisplus.entity.UserEntity;
import com.coolw.mybatisplus.util.PageResult;

import java.util.List;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:19
 * @since 1.0
 */
public interface UserService extends IService<UserEntity> {

    PageResult<UserEntity> pageList(UserReportReq req);

    List<UserExcel> export(UserReportReq req);
}
