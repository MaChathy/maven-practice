package com.fisher.mybatis.dao;

import com.fisher.mybatis.baseoperate.entity.Employees;
import com.fisher.mybatis.lomboks.Employee;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MyBatis数据输出测试
 * v1.0,1 返回单个简单数据类型
 * v1.1.1 返回map类型
 * v1.2.1 返回List类型
 *
 * @author fisher
 * @version 1.2.1 2023/6/2 - 14:48
 */
@Slf4j
public class EmployeeMapperTest {

    private EmployeeMapper employeeMapper ;
    private SqlSession sqlSession ;

    @Before
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsReader("mybatis-config.xml")
                ).openSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    @After
    public void clean(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectEmployeeCount(){
        int empCount = employeeMapper.selectEmployeeCount();
        log.info("Employee count is " + empCount);
    }

    @Test
    public void testSelectEmployeeList(){
        List<Employees> employeeList = employeeMapper.selectEmployeeList();
        for(var e:employeeList){
            log.info(e.toString());
        }
    }

    @Test
    public void testSelectEmpNameAndMaxSalary(){
        Map<String,Object> resMap = employeeMapper.selectEmpNameAndMaxSalary();
        for (Map.Entry<String,Object> entry : resMap.entrySet()){
            log.info(entry.getKey() + ": " + entry.getValue());
        }
    }
}