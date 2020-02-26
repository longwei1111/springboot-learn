package com.coody.springboottransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.coody.springboot10.dao")
public class SpringbootTransactionApplication {

    /** Spring Boot事务配置管理 */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionApplication.class, args);
    }

}
