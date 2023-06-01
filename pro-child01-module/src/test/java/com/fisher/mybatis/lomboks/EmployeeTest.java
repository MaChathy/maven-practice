package com.fisher.mybatis.lomboks;

import lombok.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试使用lombok注解的类
 * @author fisher
 * @version 1.0.1 2023/6/1 - 20:00
 */
public class EmployeeTest {

    private Logger empLog = LoggerFactory.getLogger(Employee.class);

    @Test
    public void testLombokAnnotations() {
        Employee employee = new Employee();
        employee.setEmpId("123");
        employee.setEmpName("Fisher");
        employee.setEmpSalary(1000.0);
        empLog.info(employee.toString());
    }

}