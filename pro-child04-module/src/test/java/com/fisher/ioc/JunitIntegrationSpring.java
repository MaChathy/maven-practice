package com.fisher.ioc;

import com.fisher.ioc.controller.BankMgrController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 整合junit测试
 *
 * @author fisher
 * @version 1.0.1 2023/6/10 - 13:59
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class JunitIntegrationSpring {

    @Autowired()
    private BankMgrController bankMgrController;

    @Test
    public void testIntegration(){
        bankMgrController.getMessages();
    }

    @Test
    public void testSome(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);

    }
}
