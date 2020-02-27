package com.coody.springboottask.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Classname MyTimeTask
 * @Description 定时任务
 * @Author lw
 * @Date 2020-02-27 21:10
 */
@Slf4j
@Component
public class MyTimeTask {

    /*
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 10000) ：上一次执行完毕时间点之后10秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=15000) ：第一次延迟1秒后执行，之后按fixedRate的规则每15秒执行一次
     * @Scheduled(cron="/5") ：通过cron表达式定义规则
     */

    /**
     * 上一次开始执行时间点之后5秒再执行
     */
    @Async("taskScheduler")
    @Scheduled(fixedRate = 5000)
    public void task_1() {
        log.info("task_1 当前时间：{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * 上一次执行完毕时间点之后10秒再执行
     */
    @Scheduled(fixedDelay = 10000)
    public void task_2() {
        log.info("task_2 当前时间：{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * 第一次延迟1秒后执行，之后按fixedRate的规则每15秒执行一次
     */
    @Scheduled(initialDelay = 1000, fixedRate = 15000)
    public void task_3() {
        log.info("task_3 当前时间：{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * 每20秒执行一次
     */
    @Scheduled(cron = "*/20 * * * * ?")
    public void task_4() {
        log.info("task_4 当前时间：{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
