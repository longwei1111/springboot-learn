package com.coody.springbootmongodb.dao;


import com.coody.springbootmongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname StudentRepository
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 15:55
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
