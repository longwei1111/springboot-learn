package com.coolw.acutator.compoent;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Classname MyHealthIndicatoy
 * @Description 自定义健康检查
 * @Date 2021/1/18 16:55
 * @Author lw
 */
@Component
public class MyHealthIndicatoy implements HealthIndicator {

    @Override
    public Health health() {
        return new Health.Builder().withDetail("myFlag", "Y")
                .withDetail("myStatus", "UP").up().build();
    }
}
