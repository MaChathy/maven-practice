package com.fisher.mybatis.lomboks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用Lombok注解的类
 * @author fisher
 * @version 1.0.1 2023/6/1 - 19:48
 */
@Data //生成getter和setter方法
@NoArgsConstructor //生成无参构造器
@AllArgsConstructor //生成全参构造器
@Slf4j //
public class Employee {

    //员工id
    private String empId;
    //员工姓名
    private String empName;
    //员工薪水
    private Double empSalary;

}
