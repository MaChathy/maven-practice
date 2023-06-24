package com.fisher.practice02;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.fisher.practice02.ssm.entry.Soldier;
import com.fisher.practice02.ssm.mapper.SoldierMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/24 - 18:30
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-persist.xml")
public class SSMTest {

    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private SoldierMapper soldierMapper;

    @Test
    public void testSSMStart() throws Exception {

        DruidPooledConnection connection = druidDataSource.getConnection();
        log.debug("connection:"+connection.toString());

    }

    @Test
    public void testMybatis(){

        List<Soldier> soldiers = soldierMapper.selectAll();

        for (Soldier soldier : soldiers){
            log.debug(soldier.toString());
        }
    }

}
