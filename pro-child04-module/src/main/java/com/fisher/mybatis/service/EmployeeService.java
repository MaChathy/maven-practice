package com.fisher.mybatis.service;

import com.fisher.mybatis.mapper.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务相关
 * @author fisher
 * @version 1.0.1 2023/6/13 - 12:25
 */
@Service(value = "employeeService")
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(@Qualifier(value = "employeeDao") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void updateTwice(
            Integer empIdEditName,String newName,
            Integer empIdEditSalary,Double newSalary){

        employeeDao.updateEmployeeNameById(empIdEditName,newName);
        employeeDao.updateEmployeeSalaryById(empIdEditSalary,newSalary);
    }

}
