package com.coolw.mongodb.service;

import com.coolw.mongodb.entity.Student;

import java.util.List;

/**
 * @Classname StudentService
 * @Description
 * @Author lw
 * @Date 2020-02-27 16:01
 */
public interface StudentService {

    Student addStudent(Student student);

    void deleteStudentById(long id);

    Student updateStudent(Student student);

    Student findStudentById(long id);

    List<Student> findAllStudent();
}
