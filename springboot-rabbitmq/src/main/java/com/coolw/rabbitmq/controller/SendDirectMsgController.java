package com.coolw.rabbitmq.controller;

import com.coolw.rabbitmq.provider.direct.DirectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-26 14:07
 */
@RestController
public class SendDirectMsgController {

    @Resource
    private DirectProvider directProvider;

    @GetMapping("/direct/send")
    public String sendDirectMessage() {
        directProvider.sendDirectMessage();
        return "send OK";
    }
}
