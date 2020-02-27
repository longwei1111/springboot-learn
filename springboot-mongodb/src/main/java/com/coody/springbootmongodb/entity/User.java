package com.coody.springbootmongodb.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 14:54
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5853600496351573556L;

    private Integer id;
    private String username;
    private String password;
}
