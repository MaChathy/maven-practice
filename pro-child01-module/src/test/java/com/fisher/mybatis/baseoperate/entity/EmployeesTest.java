package com.fisher.mybatis.baseoperate.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Mybatis 的基本操作-单个查询测试
 * @author fisher
 * @version 1.0.1 2023/6/1 - 22:24
 */
public class EmployeesTest {

    @Test
    public void testSelectEmployee() throws IOException {
        //创建SqlSessionFactory对象
        //声明Mybatis全局配置文件
        String maBatisConfigPath = "mybatis-config.xml";
        //以输入流的形式加载mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(maBatisConfigPath);
        //读取mybatis配置文件的输入流，并创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用sqlSessionFactory开启一个会话
        SqlSession session = sessionFactory.openSession();

        //根据Mapper配置文件的命名空间+SQL语句的id找到具体的SQL语句
        //格式：命名空间.SQL语句的id
        String statement = "com.fisher.mybatis.dao.EmployeeMapper.selectEmployee";

        //传入参数
        Integer empId = 1;
        //执行SQL语句
        Employees empResult = (Employees)session.selectOne(statement, empId);
        //Logger.getLogger(this.getClass().getName()).info(empResult.toString());
        LoggerFactory.getLogger(this.getClass().getName()).info("empResult = " + empResult);
        //关闭输入流
        inputStream.close();

    }

}