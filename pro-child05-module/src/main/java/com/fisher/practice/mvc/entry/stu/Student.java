package com.fisher.practice.mvc.entry.stu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 学生实体类
 * @author fisher
 * @version 1.0.1 2023/6/14 - 13:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String stuName;

    private School school;

    private List<Subject> subjectList;

}
