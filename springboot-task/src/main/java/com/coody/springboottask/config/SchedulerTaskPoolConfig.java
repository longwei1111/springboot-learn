package com.coody.springboottask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @Classname SchedulerTaskPoolConfig
 * @Description 定时任务-线程池配置
 * @Author lw
 * @Date 2020-02-27 22:24
 */
@Configuration
public class SchedulerTaskPoolConfig implements SchedulingConfigurer {

    /**
     * 定时任务使用的线程池
     */
    @Bean(destroyMethod = "shutdown", name = "taskScheduler")
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // 设置线程池数
        scheduler.setPoolSize(10);
        // 设置线程名称前缀
        scheduler.setThreadNamePrefix("taskScheduler-");
        // 设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        scheduler.setAwaitTerminationSeconds(600);
        return scheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler scheduler = taskScheduler();
        scheduledTaskRegistrar.setTaskScheduler(scheduler);
    }
}
