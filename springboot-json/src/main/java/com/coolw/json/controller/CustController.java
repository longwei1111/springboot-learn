package com.coolw.json.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.json.entity.Cust;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description
 * @Author coolw
 * @Date 2020-08-14 20:45
 */
@RestController
public class CustController {

    @GetMapping("/cust/getCust")
    public BaseResponse getCust() {
        Cust cust = new Cust();
        cust.setCustName("张三");
        cust.setIdNo("430623194444444448888");
        cust.setIdType("1");
        cust.setMoney(new BigDecimal("100.00"));
        return BaseResponse.success(cust);
    }
}
