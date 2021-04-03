package com.coolw.function.email.controller;

import com.coolw.function.email.service.EmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname EmailController
 * @Description
 * @Date 2021/4/9 15:05
 * @Author lw
 */
@RestController
public class EmailController {

    @Resource
    private EmailService emailService;

    @RequestMapping("/email/send")
    public void testSendEmail() {
        emailService.simpleSendEmail();
    }

}
