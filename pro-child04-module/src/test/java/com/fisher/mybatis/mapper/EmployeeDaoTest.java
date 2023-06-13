package com.fisher.mybatis.mapper;

import com.fisher.mybatis.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试Dao层
 * @author fisher
 * @version 1.0.1 2023/6/13 - 12:20
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class EmployeeDaoTest {

    @Autowired()
    @Qualifier(value = "employeeDao")
    private EmployeeDao employeeDao;

    @Autowired
    @Qualifier(value = "employeeService")
    private EmployeeService employeeService;

    @Test
    public void testSelectEmployeeNameById(){
        String employeeNameById = employeeDao.selectEmployeeNameById(1);

        log.debug("EmployeeDao.selectEmployeeNameById = " + employeeNameById);
    }

    @Test
    public void testUpdateEmpTwiceWithoutTransactionManager(){
        employeeService.updateTwice(1,"test2",1,1024.1);
    }

    @Test
    public void testReadOnlyTransactionManager(){
        String employeeNameById = employeeService.getEmployeeNameById(1);
        log.debug("readOnlyTransactionManager = " + employeeNameById);
    }

}