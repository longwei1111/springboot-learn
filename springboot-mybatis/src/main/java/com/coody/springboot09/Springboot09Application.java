package com.coody.springboot09;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.coody.springboot09.dao")
public class Springboot09Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09Application.class, args);
    }

}
