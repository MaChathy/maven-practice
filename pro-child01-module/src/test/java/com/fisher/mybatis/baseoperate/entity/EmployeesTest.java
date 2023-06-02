package com.fisher.mybatis.baseoperate.entity;

import com.fisher.mybatis.dao.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;


/**
 * Mybatis 的基本操作-单个查询测试
 * v1.1.1优化测试
 * v1.2.1测试Mapper接口
 * @author fisher
 * @version 1.1.1 2023/6/1 - 22:24
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

    }



}