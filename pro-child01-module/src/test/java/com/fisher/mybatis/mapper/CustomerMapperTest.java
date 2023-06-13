package com.fisher.mybatis.mapper;

import ch.qos.logback.core.util.TimeUtil;
import com.fisher.mybatis.baseoperate.entity.Customer;
import com.fisher.mybatis.baseoperate.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        Customer customer = customerMapper.selectCustomerWithOrderList(1);
        log.info("customer.getCustomerId() = "+customer.getCustomerId());
        log.info("customer.getCustomerName() = "+customer.getCustomerName());
        for (Order order : customer.getOrderList()) {
            log.info("order:"+order);
        }
    }

    @Test
    public void testLazyLoadingSelectCustomerWithOrderList(){
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.selectCustomerWithOrderList(1);

        log.info("customer:"+customer.getCustomerId()+"-"+customer.getCustomerName());

        TimeUtil.computeStartOfNextSecond(10);

        List<Order> orders = customer.getOrderList();

        for (Order order : orders) {
            log.info("order:"+order);
        }

    }
}