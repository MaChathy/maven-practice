package com.fisher.mybatis.baseoperate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * 和数据库表t_emp对应的实体类
 * emp_id int primary key auto_increment
 * emp_name char(100)
 * emp_salary double(10,5)
 *
 * Java的实体类中字段(Field)不要使用基本数据类型，要使用包装类型
 * 基本数据类型不可以赋值为null，包装类型可以
 * v1.1.1生成Slf4j对象
 * @author fisher
 * @version 1.1.1 2023/6/1 - 21:40
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    private Integer empId;

    private String empName;

    private Double empSalary;

}
