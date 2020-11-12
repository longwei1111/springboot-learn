package com.coolw.mongodb.controller;

import com.coolw.common.api.ResultResponse;
import com.coolw.mongodb.entity.Student;
import com.coolw.mongodb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname StudentController
 * @Description
 * @Author lw
 * @Date 2020-02-27 16:13
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 新增学生信息
     */
    @PostMapping("/student/add")
    public ResultResponse<Student> addStudent(@RequestBody Student student) {
        Student result = studentService.addStudent(student);
        return new ResultResponse().success(result);
    }

    /**
     * 根据id查询学生信息
     */
    @PostMapping("/student/query/{id}")
    public ResultResponse<Student> findStudentById(@PathVariable long id) {
        Student student = studentService.findStudentById(id);
        return new ResultResponse().success(student);
    }

    /**
     * 获取学生信息列表
     */
    @GetMapping("/student/getAll")
    public ResultResponse<List<Student>> findAllStudent() {
        List<Student> studentList = studentService.findAllStudent();
        return new ResultResponse().success(studentList);
    }

    /**
     * 更新学生信息
     */
    @PostMapping("/student/update")
    public ResultResponse<Student> updateStudent(Student student) {
        Student result = studentService.updateStudent(student);
        return new ResultResponse().success(result);
    }

    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/student/delete/{id}")
    public ResultResponse deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentById(id);
        return new ResultResponse().success();
    }
}
