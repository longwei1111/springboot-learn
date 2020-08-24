package com.coolw.task.controller;

import com.coolw.task.task.AsyncTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname AsyncController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 21:38
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Resource
    private AsyncTask asyncTask;

    @GetMapping("/task")
    public String asyncTask() {
        asyncTask.asyncTask1();
        asyncTask.asyncTask2();
        return "success";
    }

    /**
     * 测试并发-异步线程池
     */
    @GetMapping("/tasks")
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
