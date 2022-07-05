package com.coolw.mybatis.entity;

import com.coolw.common.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 用户实体类
 * @Author coolw
 * @Date 2020-02-25 11:29
 */
@Getter
@Setter
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -7879248949762451388L;

    /** 用户号 */
    private String userNo;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String password;

    /** 手机号 */
    private String mobileNo;

    /** 地址 */
    private String address;

    /** 用户状态 */
    private String userStatus;
}
