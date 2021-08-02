package com.coolw.function.qrcode.controller;

import com.coolw.function.qrcode.service.QrCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Date 2021/4/9 13:55
 * @Author coolw
 */
@RestController
public class QrCodeController {

    @Resource
    private QrCodeService qrCodeService;

    @GetMapping("/qrCode/{orderNo}")
    public String getQrCodePayUrl(@PathVariable String orderNo) {
        return qrCodeService.generateQrCodePayUrl(orderNo);
    }

}
