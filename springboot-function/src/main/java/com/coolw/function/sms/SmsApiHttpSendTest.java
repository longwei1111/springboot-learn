package com.coolw.function.sms;

import com.coolw.function.sms.config.MDYConfig;
import com.coolw.function.sms.util.HttpUtils;

import java.net.URLEncoder;
import java.util.Random;

/**
 * @Classname SmsApiHttpSendTest
 * @Description
 * @Date 2021/4/9 16:20
 * @Author lw
 */
public class SmsApiHttpSendTest {

    private static String sendTo = "15000994425";
    private static String tempSmsContent = "【coolw】登录验证码：{" + runNumber() + "}，如非本人操作，请忽略此短信。";

    /**
     * 验证码通知短信
     */
    private static void execute() {
        String smsContent;
        try {
            smsContent = URLEncoder.encode(tempSmsContent, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("短信内容编码不合法");
        }

        StringBuilder body = new StringBuilder();
        body.append("accountSid").append("=").append(MDYConfig.ACCOUNT_SID);
        body.append("&to").append("=").append(sendTo);
        body.append("&smsContent").append("=").append(smsContent);
        body.append(HttpUtils.createCommonParam());
        String result = HttpUtils.post(MDYConfig.BASE_URL, body.toString());
        System.out.println("result:" + result);
    }

    public static String runNumber() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String code = sb.toString();
        System.out.println("sms code:" + code);
        return code;
    }

    public static void main(String[] args) {
        execute();
    }

}
