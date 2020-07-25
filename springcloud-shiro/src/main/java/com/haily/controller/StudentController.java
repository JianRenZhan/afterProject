package com.haily.controller;

import java.util.List;

import com.haily.domain.Student;
import com.haily.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学生 信息操作处理
 *
 * @author d
 * @date 2020-06-09
 */
@RestController
@RequestMapping("/student")
public class StudentController  {

    @Autowired
    private IStudentService studentService;

    /**
     * 查询学生列表
     */
    @GetMapping("/list")
    public List<Student> list(Student student) {
        List<Student> list = studentService.selectStudentList(student);
        return list;
    }

}