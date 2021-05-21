package com.coolw.task.threadpool;

import lombok.Data;

/**
 * @Description 线程池配置属性
 * @Date 2021/5/21 15:51
 * @Author coolw
 */
@Data
public class ThreadProperties {

    /** 核心线程数 */
    private int corePoolSize;

    /** 最大线程数 */
    private int maxPoolSize;

    /** 线程存储队列数 */
    private int queueSize;

    /** 允许非核心线程的空闲时间 */
    private long keepAlive;

    /** 线程名称前缀 */
    private String namePrefix;

}
