package com.fisher.mybatis.service;

import com.fisher.mybatis.mapper.EmployeeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务相关
 * v1.0.1 基本事务控制
 * v1.1.1 只读事务控制
 * v1.2.1 事务属性超时
 * @author fisher
 * @version 1.0.1 2023/6/13 - 12:25
 */
@Slf4j
@Service(value = "employeeService")
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(@Qualifier(value = "employeeDao") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(readOnly = false,timeout = 3)
    public void updateTwice(
            Integer empIdEditName,String newName,
            Integer empIdEditSalary,Double newSalary){

        employeeDao.updateEmployeeNameById(empIdEditName,newName);
        employeeDao.updateEmployeeSalaryById(empIdEditSalary,newSalary);
    }

    public String getEmployeeNameById(Integer empId){
        String name = employeeDao.selectEmployeeNameById(empId);
        log.debug("getEmployeeNameById : "+name);
        return name;
    }

}
