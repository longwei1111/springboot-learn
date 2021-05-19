package com.coolw.function.qrcode.service;

/**
 * @Description 二维码服务接口
 * @Date 2021/4/9 13:35
 * @Author coolw
 */
public interface QrCodeService {

    /**
     * 生成二维码支付链接
     *
     * @param orderNo 订单号
     * @return String
     */
    String generateQrCodePayUrl(String orderNo);
}
