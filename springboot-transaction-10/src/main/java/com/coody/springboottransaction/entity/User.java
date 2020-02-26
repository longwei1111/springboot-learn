package com.coody.springboottransaction.entity;

import lombok.Data;

/**
 * @Classname User
 * @Description 用户信息
 * @Author lw
 * @Date 2020-02-25 11:29
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String password;
}
