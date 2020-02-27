package com.coody.springbootmongodb.controller;

import com.coody.springbootmongodb.entity.Student;
import com.coody.springbootmongodb.result.JsonResult;
import com.coody.springbootmongodb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname StudentController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-27 16:13
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentService studentService;

    /**
     * 新增学生信息
     *
     * @param student
     * @return
     */
    @PostMapping("/add")
    public JsonResult<Student> addStudent(@RequestBody Student student) {
        Student result = studentService.addStudent(student);
        return new JsonResult<>(result);
    }

    /**
     * 根据id查询学生信息
     *
     * @param id
     * @return
     */
    @PostMapping("/query/{id}")
    public JsonResult<Student> findStudentById(@PathVariable String id) {
        Student student = studentService.findStudentById(id);
        return new JsonResult<>(student);
    }

    /**
     * 获取学生信息列表
     *
     * @return
     */
    @GetMapping("/getAll")
    public JsonResult<List<Student>> findAllStudent() {
        List<Student> studentList = studentService.findAllStudent();
        return new JsonResult<>(studentList);
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @PostMapping("/update")
    public JsonResult<Student> updateStudent(Student student) {
        Student result = studentService.updateStudent(student);
        return new JsonResult<>(result);
    }

    /**
     * 根据id删除学生信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public JsonResult deleteStudentById(@PathVariable String id) {
        studentService.deleteStudentById(id);
        return new JsonResult();
    }
}
