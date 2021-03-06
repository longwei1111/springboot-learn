package com.coolw.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-27 15:57
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 7880969874834666960L;

    @Id
    private long id;
    private String name;
    private String sex;
    private int age;
}
