package com.coolw.email;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class SpringbootEmailApplicationTests {

    @Resource
    private JavaMailSender javaMailSender;

    @Test
    void testSendEmail() {
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
