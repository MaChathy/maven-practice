package com.fisher.mybatis.baseoperate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 和数据库表t_emp对应的实体类
 * emp_id int primary key auto_increment
 * emp_name char(100)
 * emp_salary double(10,5)
 *
 * Java的实体类中字段(Field)不要使用基本数据类型，要使用包装类型
 * 基本数据类型不可以赋值为null，包装类型可以
 * @author fisher
 * @version 1.0.1 2023/6/1 - 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    private Integer empId;

    private String empName;

    private Double empSalary;

}
