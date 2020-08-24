package com.coolw.rabbitmq.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Classname DateUtil
 * @Description 日期工具类
 * @Author lw
 * @Date 2020-07-22 15:19
 */
public class DateUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String currentDateTime(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }
}
