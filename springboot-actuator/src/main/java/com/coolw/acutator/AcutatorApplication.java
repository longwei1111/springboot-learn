package com.coolw.acutator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcutatorApplication {

    /**
     * Spring Boot 提供了多项组件的健康检查,有利于监控各组件运行状态
     * 常用EndPoint:
     *      /health 应用的健康状态
     *      /configprops 应用的配置信息
     *      /trace 最近几次的http请求信息
     */
    public static void main(String[] args) {
        SpringApplication.run(AcutatorApplication.class, args);
    }

}
