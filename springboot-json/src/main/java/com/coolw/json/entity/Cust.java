package com.coolw.json.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description
 * @Author coolw
 * @Date 2020-08-14 10:53
 */
@Data
public class Cust {

    private String custName;
    private String idNo;

    // 被忽略
    @JsonIgnore
    private String idType;

    // 指定key别名
    @JsonProperty("userMoney")
    private BigDecimal money;
}
