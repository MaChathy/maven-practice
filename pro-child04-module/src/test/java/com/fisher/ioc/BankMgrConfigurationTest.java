package com.fisher.ioc;

import com.fisher.ioc.controller.BankMgrController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配AutoWeird测试
 * @author fisher
 * @version 1.1.1 2023-6-10 11:50:13
 */
class BankMgrConfigurationTest {

    @Test
    public void testAutoWeird(){
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext();

        BankMgrController bankMgrController = (BankMgrController) iocContainer.getBean("bankMgrController");

        bankMgrController.getMessages();

    }
}