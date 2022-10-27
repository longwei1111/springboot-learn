package com.coolw.mongodb.controller;

import com.coolw.common.api.BaseResponse;
import com.coolw.mongodb.entity.Student;
import com.coolw.mongodb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author coolw
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
    public BaseResponse<Student> addStudent(@RequestBody Student student) {
        Student result = studentService.addStudent(student);
        return BaseResponse.success(result);
    }

    /**
     * 根据id查询学生信息
     */
    @PostMapping("/student/query/{id}")
    public BaseResponse<Student> findStudentById(@PathVariable long id) {
        Student student = studentService.findStudentById(id);
        return BaseResponse.success(student);
    }

    /**
     * 获取学生信息列表
     */
    @GetMapping("/student/getAll")
    public BaseResponse<List<Student>> findAllStudent() {
        List<Student> studentList = studentService.findAllStudent();
        return BaseResponse.success(studentList);
    }

    /**
     * 更新学生信息
     */
    @PostMapping("/student/update")
    public BaseResponse<Student> updateStudent(Student student) {
        Student result = studentService.updateStudent(student);
        return BaseResponse.success(result);
    }

    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/student/delete/{id}")
    public BaseResponse deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentById(id);
        return BaseResponse.success();
    }
}
