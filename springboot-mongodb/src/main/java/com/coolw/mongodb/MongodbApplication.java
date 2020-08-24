package com.coolw.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbApplication {

    /**
     * MongoDB：是由 C++ 编写的非关系型数据库，是一个基于分布式文件存储的开源数据库系统，
     * 它将数据存储为一个文档，数据结构由键值 (key=>value) 对组成。
     */

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

}
