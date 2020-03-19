package com.coody.springboot.param.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname MicroUrlService
 * @Description ConfigurationProperties可以批量注入属性值
 * @Author lw
 * @Date 2020-02-22 19:14
 */
@Data
@Component
@ConfigurationProperties(prefix = "url")
public class MicroUrlService {

    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;
}
