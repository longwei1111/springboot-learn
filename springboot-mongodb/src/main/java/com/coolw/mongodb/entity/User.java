package com.coolw.mongodb.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname User
 * @Description
 * @Author lw
 * @Date 2020-02-27 14:54
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5853600496351573556L;

    private long id;
    private String username;
    private String password;
}
