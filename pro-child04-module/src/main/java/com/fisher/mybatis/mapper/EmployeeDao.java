package com.fisher.mybatis.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * 基于注解的事务测试
 * @author fisher
 * @version 1.0.1 2023/6/13 - 12:10
 */
@Repository(value = "employeeDao")
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(@Qualifier(value = "jdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void updateEmployeeNameById(Integer empId,String empName){
        String sql = "update t_emp set emp_name = ? where emp_id = ?";
        jdbcTemplate.update(sql, empName, empId);
        int i = 10/0;
    }

    public void updateEmployeeSalaryById(Integer empId,Double empSalary){
        String sql = "UPDATE t_emp set emp_salary = ? where emp_id = ?";
        jdbcTemplate.update(sql,empSalary, empId);
    }

    public String selectEmployeeNameById(Integer empId){
        String sql = "select emp_name from t_emp where emp_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, empId);
    }
}
