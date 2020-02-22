package com.coody.springboot03.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname MicroUrlService
 * @Description TODO
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
