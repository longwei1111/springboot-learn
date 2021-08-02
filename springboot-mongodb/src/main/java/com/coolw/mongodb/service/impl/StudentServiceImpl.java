package com.coolw.mongodb.service.impl;

import com.coolw.mongodb.dao.StudentRepository;
import com.coolw.mongodb.entity.Student;
import com.coolw.mongodb.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author coolw
 * @Date 2020-02-27 16:00
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    /**
     * 添加学生信息
     */
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * 删除学生信息
     */
    @Override
    public void deleteStudentById(long id) {
        Student student = findStudentById(id);
        if (Objects.nonNull(student)) {
            studentRepository.deleteById(id);
        } else {
            log.info("student is not exist");
        }
    }

    /**
     * 更新学生信息
     */
    @Override
    public Student updateStudent(Student student) {
        Student oldStudent = findStudentById(student.getId());
        if (Objects.nonNull(oldStudent)) {
            oldStudent.setName(student.getName());
            oldStudent.setSex(student.getSex());
            oldStudent.setAge(student.getAge());
            return studentRepository.save(oldStudent);
        } else {
            log.info("student is not exist");
            return null;
        }
    }

    /**
     * 根据id查询学生信息
     */
    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    /**
     * 获取学生信息列表
     */
    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
