package com.fisher.mybatis.baseoperate.entity;

import com.fisher.mybatis.dao.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;


/**
 * Mybatis 的基本操作-curd(增删改查)
 *
 * v1.1.1优化测试
 * v1.2.1测试Mapper接口
 * v1.3.1新增测试：增、删、改
 *
 * @author fisher
 * @version 1.3.1 2023/6/1 - 22:24
 */
@Slf4j
public class EmployeesTest {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        this.sqlSession = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml")
                )
                .openSession();
    }

    @After
    public void clear(){
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @Test
    public void testSelectEmployee() {
        /*
        //创建SqlSessionFactory对象
        //声明Mybatis全局配置文件
        String maBatisConfigPath = "mybatis-config.xml";
        //以输入流的形式加载mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(maBatisConfigPath);
        //读取mybatis配置文件的输入流，并创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用sqlSessionFactory开启一个会话
        SqlSession session = sessionFactory.openSession();
        */
        //根据Mapper配置文件的命名空间+SQL语句的id找到具体的SQL语句

        //格式：命名空间.SQL语句的id
        String statement = "com.fisher.mybatis.dao.EmployeeMapper.selectEmployee";

        //传入参数
        Integer empId = 1;
        //执行SQL语句
        Object empResult = this.sqlSession.selectOne(statement, empId);
        //Logger.getLogger(this.getClass().getName()).info(empResult.toString());
        log.info(empResult.toString());
    }

    @Test
    public void testUseMapperInterface(){
        EmployeeMapper employeeMapper = this.sqlSession.getMapper(EmployeeMapper.class);
        Employees empResult = employeeMapper.selectEmployee(1);
        if (empResult!=null)
            log.info(empResult.toString());
    }

    @Test
    public void testInsertEmployee(){
        EmployeeMapper employeeMapper = this.sqlSession.getMapper(EmployeeMapper.class);
        int res = employeeMapper.insertEmployee(new Employees(null,"李冲",1000.11));
        log.info("rows = "+ res);
    }

    @Test
    public void testUpdateEmployee(){
        EmployeeMapper employeeMapper = this.sqlSession.getMapper(EmployeeMapper.class);
        int updateEmployee = employeeMapper.updateEmployee(new Employees(4, "李冲", 1000.11));
        log.info("rows = "+ updateEmployee);
    }

    @Test
    public void testDeleteEmployee(){
        EmployeeMapper employeeMapper = this.sqlSession.getMapper(EmployeeMapper.class);
        int res = employeeMapper.deleteEmployee(new Employees(4,null,null));
        log.info("rows = "+res);
    }
}