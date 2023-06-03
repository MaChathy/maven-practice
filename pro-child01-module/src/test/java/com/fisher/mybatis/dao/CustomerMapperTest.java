package com.fisher.mybatis.dao;

import com.fisher.mybatis.baseoperate.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * “对多”测试
 * CustomerMapper.xml关键字：collocation、ofType
 * @author fisher
 * @version 1.0.1 2023/6/2 - 18:19
 */
@Slf4j
public class CustomerMapperTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsReader("mybatis-config.xml")
        ).openSession();
        log.info("开始测试...");
    }
    @After
    public void clean(){
        sqlSession.commit();
        sqlSession.close();
        log.info("结束测试...");
    }

    @Test
    public void testRelationshipToMultiple(){
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.selectCustomerWithOrder(1);
        log.info("Customer:"+customer.toString());
    }
}