package com.haily.mapper;

import com.haily.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生 数据层
 *
 * @author d
 * @date 2020-06-09
 */
@Repository
public interface StudentMapper {

    /**
     * 查询学生信息
     *
     * @param id 学生ID
     * @return 学生信息
     */
    public Student selectStudentById(Integer id);

    /**
     * 查询学生列表
     *
     * @param student 学生信息
     * @return 学生集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增学生
     *
     * @param student 学生信息
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改学生
     *
     * @param student 学生信息
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 删除学生
     *
     * @param id 学生ID
     * @return 结果
     */
    public int deleteStudentById(Integer id);

    /**
     * 批量删除学生
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentByIds(String[] ids);
}