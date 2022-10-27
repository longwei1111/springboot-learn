- pom添加mybatis依赖
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.2</version>
</dependency>
```

- application.yml添加mybatis配置
```yml
mybatis:
  # mapper文件映射位置
  mapper-locations: classpath:/mapper/*.xml
  # 指定实体类别名
  type-aliases-package: com.coolw.mybatis.entity
  configuration:
    # 下划线自动转驼峰
    map-underscore-to-camel-case: true
```

- 启动类添加@MapperScan注解
```java
@SpringBootApplication
@MapperScan("com.coolw.mybatis.dao")
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
```