package com.coody.springbootslf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSlf4jApplication {

    /**
     * Spring Boot使用slf4j进行日志记录
     *
     * SLF4J:即简单日志门面（Simple Logging Facade for Java），不是具体的日志解决方案，
     * 它只服务于各种各样的日志系统。按照官方的说法，SLF4J是一个用于日志系统的简单Facade，
     * 允许最终用户在部署其应用时使用其所希望的日志系统。
     *
     * 常用的日志级别按照从高到低依次为：ERROR > WARN > INFO > DEBUG。
     * */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSlf4jApplication.class, args);
    }

}
