package com.coolw.mongodb.repository;


import com.coolw.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-27 15:55
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

}
