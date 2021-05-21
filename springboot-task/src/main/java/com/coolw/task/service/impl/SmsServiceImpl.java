package com.coolw.task.service.impl;

import com.coolw.task.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2021/5/21 16:21
 * @Author coolw
 */
@Slf4j
@Service("smsService")
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(String mobileNo) {
        log.info("手机号[{}]发生短信成功......", mobileNo);
    }

}
