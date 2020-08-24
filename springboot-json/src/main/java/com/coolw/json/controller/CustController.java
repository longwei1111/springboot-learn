package com.coolw.json.controller;

import com.coolw.json.entity.Cust;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Classname CustController
 * @Description TODO
 * @Author lw
 * @Date 2020-08-14 20:45
 */
@RestController
@RequestMapping("/cust")
public class CustController {

    @GetMapping("/getCust")
    public Cust getCust() {
        Cust cust = new Cust();
        cust.setCustName("张三");
        cust.setIdNo("430623194444444448888");
        cust.setIdType("1");
        cust.setMoney(new BigDecimal("100.00"));
        return cust;
    }
}
