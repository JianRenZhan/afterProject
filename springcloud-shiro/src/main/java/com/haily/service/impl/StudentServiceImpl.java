package com.haily.service.impl;

import java.util.List;

import com.haily.domain.Student;
import com.haily.mapper.StudentMapper;
import com.haily.service.IStudentService;
import com.haily.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生 服务层实现
 *
 * @author d
 * @date 2020-06-09
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生信息
     *
     * @param id 学生ID
     * @return 学生信息
     */
    @Override
    public Student selectStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询学生列表
     *
     * @param student 学生信息
     * @return 学生集合
     */
    @Override
    public List<Student> selectStudentList(Student student) {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改学生
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    /**
     * 删除学生对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentByIds(String ids) {
        return studentMapper.deleteStudentByIds(Convert.toStrArray(ids));
    }
}