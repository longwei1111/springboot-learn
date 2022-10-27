package com.coolw.task.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.task.task.AsyncTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-27 21:38
 */
@RestController
public class AsyncController {

    @Resource
    private AsyncTask asyncTask;

    @GetMapping("/async/task")
    public BaseResponse asyncTask() {
        asyncTask.asyncTask1();
        asyncTask.asyncTask2();
        return BaseResponse.success();
    }

    /**
     * 测试并发-异步线程池
     */
    @GetMapping("/async/tasks")
    public void tasks() {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    asyncTask.asyncTask1();
                }
            }).start();
        }
    }
}
