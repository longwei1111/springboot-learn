package com.coolw.task.service.impl;

import com.coolw.task.service.OrderChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description 拼多多订单渠道
 * @Date 2021/5/21 16:21
 * @Author coolw
 */
@Slf4j
@Service("pddOrderChannelService")
public class PDDOrderChannelServiceImpl implements OrderChannelService {

    @Override
    public void createOrder() {
        log.info("拼多多创建订单成功......");
    }

}
