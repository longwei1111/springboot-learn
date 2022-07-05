package com.coolw.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coolw.mybatisplus.domain.req.UserReportReq;
import com.coolw.mybatisplus.entity.UserEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:18
 * @since 1.0
 */
// 开启MyBatis二级缓存
@CacheNamespace
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 分页查询用户信息
     *
     * @param page 分页条件，不允许为null;当为空对象时，不进行分页，查询全部
     * @param req
     * @return
     */
    IPage<UserEntity> queryPage(IPage<UserEntity> page, @Param("req") UserReportReq req);
    
}
