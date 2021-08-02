package com.coolw.function.configparam.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description ConfigurationProperties可以批量注入属性值
 * @Author coolw
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
