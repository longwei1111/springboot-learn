package com.coolw.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description 车300定价结果
 * @Date 2021/10/12 15:34
 * @Author coolw
 */
@Getter
@Setter
@Document("che300_price_result")
public class Che300PriceResultMongoEntity extends BaseMongoEntity {

    private static final long serialVersionUID = -1075077799110783177L;

    /** 车架号 */
    @Indexed
    private String vin;
}
