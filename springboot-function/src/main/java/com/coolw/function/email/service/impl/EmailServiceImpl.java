package com.coolw.function.email.service.impl;

import com.coolw.function.email.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Classname EmailServiceImpl
 * @Description
 * @Date 2021/4/9 15:09
 * @Author lw
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void simpleSendEmail() {
        /** https://blog.csdn.net/nanhuaibeian/article/details/109155827 */
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件主题
        message.setSubject("主题：测试邮件");
        // 邮件发送者
        message.setFrom("172572575@qq.com");
        // 邮件接收者
        message.setTo("172572575@qq.com");
        // 邮件发送日期
        message.setSentDate(new Date());
        // 邮件正文
        message.setText("你好：这是一个测试邮件。。。。。。。");
        // 发送邮件
        javaMailSender.send(message);
    }
}
