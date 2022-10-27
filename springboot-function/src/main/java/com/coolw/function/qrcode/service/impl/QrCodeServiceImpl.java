package com.coolw.function.qrcode.service.impl;

import com.coolw.function.qrcode.service.QrCodeService;
import com.coolw.function.qrcode.util.QRCodeGeneratorUtils;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @Description 二维码服务实现类
 * @Date 2021/4/9 13:35
 * @Author coolw
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {

    private final static String FILE_UPLOAD_PATH = "D:/QRTest.png";

    @Override
    public String generateQrCodePayUrl(String orderNo) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String address = getIp() + ":" + request.getLocalPort();
        String payUrl = "http://" + address + "/pay?orderNo=" + orderNo;

        try {
            QRCodeGeneratorUtils.generateQrCodeImage(payUrl, 350, 350, FILE_UPLOAD_PATH);
        } catch (WriterException e) {
            throw new RuntimeException("生成二维码图片写入异常", e);
        } catch (IOException e) {
            throw new RuntimeException("生成二维码图片IO流异常", e);
        }

        return "http://" + address + "/images-dev/" + orderNo + ".png";
    }

    private String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RuntimeException("获取IP异常", e);
        }
    }
}

