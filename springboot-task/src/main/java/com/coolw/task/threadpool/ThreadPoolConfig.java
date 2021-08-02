package com.coolw.task.threadpool;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description 线程池配置
 * @Date 2021/5/21 15:51
 * @Author coolw
 */
@Configuration
public class ThreadPoolConfig {

    @ConfigurationProperties("default.pool")
    @Bean("defaultThreadProperties")
    public ThreadProperties defaultThreadProperties() {
        return new ThreadProperties();
    }

    @ConfigurationProperties("order.pool")
    @Bean("orderThreadProperties")
    public ThreadProperties orderThreadProperties() {
        return new ThreadProperties();
    }

    @ConfigurationProperties("sms.pool")
    @Bean("smsThreadProperties")
    public ThreadProperties smsThreadProperties() {
        return new ThreadProperties();
    }

    @Bean("defaultExecutorService")
    public ExecutorService defaultExecutorService(@Qualifier("defaultThreadProperties") ThreadProperties properties) {
        return new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaxPoolSize()
                , properties.getKeepAlive(), TimeUnit.SECONDS, new ArrayBlockingQueue<>(properties.getQueueSize())
                , new MyThreadFactory(properties.getNamePrefix()) ,new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean("orderExecutorService")
    public ExecutorService orderExecutorService(@Qualifier("orderThreadProperties") ThreadProperties properties) {
        return new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaxPoolSize()
                , properties.getKeepAlive(), TimeUnit.SECONDS, new ArrayBlockingQueue<>(properties.getQueueSize())
                , new MyThreadFactory(properties.getNamePrefix()) ,new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean("smsExecutorService")
    public ExecutorService smsExecutorService(@Qualifier("smsThreadProperties") ThreadProperties properties) {
        return new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaxPoolSize()
                , properties.getKeepAlive(), TimeUnit.SECONDS, new ArrayBlockingQueue<>(properties.getQueueSize())
                , new MyThreadFactory(properties.getNamePrefix()) ,new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
