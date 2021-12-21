package com.coolw.mongodb.dao;

import com.coolw.mongodb.entity.Che300PriceResultMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Che300PriceResultRepository extends MongoRepository<Che300PriceResultMongoEntity, String> {

    Che300PriceResultMongoEntity findByVin(String vin);
}
