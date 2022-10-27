package com.coolw.mybatis.converter;

import com.coolw.mybatis.dto.req.UserSaveReq;
import com.coolw.mybatis.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * TODO
 *
 * @author coolw
 * @date 2022/10/27 10:45
 * @since 1.0
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserConvert {
    
    UserEntity toUserEntity(UserSaveReq req);
}
