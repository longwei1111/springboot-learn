package com.coolw.mongodb;

import cn.hutool.core.util.IdUtil;
import com.coolw.mongodb.repository.Che300PriceResultRepository;
import com.coolw.mongodb.entity.Che300PriceResultMongoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description TODO
 * @Date 2021/10/14 16:43
 * @Author coolw
 */
@SpringBootTest
public class MongoTest {

    @Resource
    private Che300PriceResultRepository che300PriceResultRepository;

    @Test
    public void testMongo() {
        Che300PriceResultMongoEntity mongoEntity = new Che300PriceResultMongoEntity();
        mongoEntity.setRequestNo(IdUtil.fastSimpleUUID());
        mongoEntity.setVin("8888888");
        mongoEntity.setCreateTime(new Date());
        mongoEntity.setUpdateTime(new Date());
        Che300PriceResultMongoEntity result = che300PriceResultRepository.save(mongoEntity);
        System.out.println(result);
    }

}
