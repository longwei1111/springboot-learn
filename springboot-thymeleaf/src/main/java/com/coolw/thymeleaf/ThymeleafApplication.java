package com.coolw.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafApplication {

    /**
     * Spring Boot集成Thymeleaf模板引擎
     *
     * Thymeleaf：
     *  1.是适用于 Web 和独立环境的现代服务器端 Java 模板引擎，
     *  2.Thymeleaf 的主要目标是为您的开发工作流程带来优雅的自然模板,
     * 可以在浏览器中正确显示的HTML，也可以用作静态原型，从而在开发团队中实现更强大的协作。
     *
     * 在html页面上如果要使用 thymeleaf 模板，需要添加<html xmlns:th="http://www.thymeleaf.org">
     */

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

}
