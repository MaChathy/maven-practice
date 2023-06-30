package com.fisher.practice02;

import com.fisher.practice02.ssm.entry.Soldier;
import com.fisher.practice02.ssm.service.api.SoldierService;
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
@ContextConfiguration(value = "classpath:application/spring-persist.xml")
public class SSMTest {

    @Autowired
    private SoldierService soldierService;

    @Test
    public void testTransactional(){
        List<Soldier> allSoldiers = soldierService.getAllSoldiers();
        for (Soldier soldier : allSoldiers){
            log.debug(soldier.toString());
        }
    }


}
