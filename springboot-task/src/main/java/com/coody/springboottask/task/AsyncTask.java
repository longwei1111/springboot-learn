package com.coody.springboottask.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Classname AsyncTask
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 21:32
 */
@Slf4j
@Component
public class AsyncTask {

    /**
     * 未指定具体的异步线程配置
     * 注：由于只有一个异步线程池配置，不指定也会默认使用该异步线程池配置
     */
    @Async("asyncExecutor1")
    public void asyncTask1() {
        try {
            // 具体业务逻辑处理

            Thread.sleep(5000);
        } catch (Exception e) {
            log.info("异步任务1：线程{}异常", Thread.currentThread().getName());
        }
        log.info("======异步任务1结束======");
    }

    /**
     * 指定了具体的异步线程池配置
     */
    @Async("asyncExecutor2")
    public void asyncTask2() {
        try {
            // 具体业务逻辑处理

            Thread.sleep(5000);
        } catch (Exception e) {
            log.info("异步任务2：线程{}异常", Thread.currentThread().getName());
        }
        log.info("======异步任务2结束======");
    }
}
