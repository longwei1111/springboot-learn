package com.coody.springbootmongodb.service;

import com.coody.springbootmongodb.entity.Student;

import java.util.List;

/**
 * @Classname StudentService
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 16:01
 */
public interface StudentService {

    Student addStudent(Student student);

    void deleteStudentById(String id);

    Student updateStudent(Student student);

    Student findStudentById(String id);

    List<Student> findAllStudent();
}
