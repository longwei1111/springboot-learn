package com.coolw.druid.entity;

import com.coolw.common.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Date 2019/11/5 8:59
 * @Author by lw
 */
@Getter
@Setter
public class User extends BaseEntity {

    private static final long serialVersionUID = -7340362585670636066L;

    private String username;
    private String password;
}
