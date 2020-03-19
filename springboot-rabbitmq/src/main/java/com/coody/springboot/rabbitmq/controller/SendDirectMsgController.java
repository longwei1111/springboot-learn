package com.coody.springboot.rabbitmq.controller;

import com.coody.springboot.rabbitmq.provider.direct.DirectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SendDirectMsgController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-26 14:07
 */
@RestController
@RequestMapping("/direct")
public class SendDirectMsgController {

    @Resource
    DirectProvider directProvider;

    @GetMapping("/send")
    public String sendDirectMessage() {
        directProvider.sendDirectMessage();
        return "send OK";
    }
}