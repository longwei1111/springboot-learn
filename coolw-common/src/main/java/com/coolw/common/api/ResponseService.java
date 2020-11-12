package com.coolw.common.api;

/**
 * @Classname ResponseService
 * @Description
 * @Date 2021/1/19 10:15
 * @Author lw
 */
public interface ResponseService {

    /**
     * 响应代码
     */
    String getResponseCode();

    /**
     * 响应信息
     */
    String getResponseMessage();
}
