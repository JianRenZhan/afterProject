package com.haily.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 学生表 student
 *
 * @author d
 * @date 2020-06-09
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID=1L;

    /**  */
    private Integer id;

    /** 名称 */
    private String stuName;

    /** 年龄 */
    private Integer stuAge;

    /** 性别 1 男 2 女 */
    private String stuSex;

    /** 住址 */
    private String stuAddress;

}