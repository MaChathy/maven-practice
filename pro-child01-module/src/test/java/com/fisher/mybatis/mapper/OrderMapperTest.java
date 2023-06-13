package com.fisher.mybatis.mapper;

import com.fisher.mybatis.baseoperate.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 对一关联测试
 * OrderMapper.xml关键词：association、javaType
 *
 * @author fisher
 * @version 1.0.1 2023/6/2 - 17:20
 */
@Slf4j
public class OrderMapperTest {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        log.info("测试开始...");
        sqlSession = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsReader("mybatis-config.xml")
        ).openSession();
    }

    @After
    public void clean(){
        sqlSession.commit();
        sqlSession.close();
        log.info("测试结束...");
    }

    @Test
    public void testRelationshipOne(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomer(1);
        log.info("Order: " + order.toString());
    }

}