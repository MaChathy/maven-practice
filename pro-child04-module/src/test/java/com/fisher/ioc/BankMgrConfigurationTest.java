package com.fisher.ioc;

import com.fisher.ioc.configuration.MyConfiguration;
import com.fisher.ioc.controller.BankMgrController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配AutoWeird测试<br>
 * <br>v1.1.1 自动扫描装配
 * <br>v1.2.1 完全注解开发
 *
 * @author fisher
 * @version 1.3.1 2023-6-10 13:56:36
 */
class BankMgrConfigurationTest {

    @Test
    public void testAutoWeird() {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");


        BankMgrController bankMgrController = iocContainer.getBean(BankMgrController.class);

        bankMgrController.getMessages();

    }

    @Test
    public void testAllAnnotations() {
        ApplicationContext iocAnnotationContainer = new AnnotationConfigApplicationContext(MyConfiguration.class);

        ((BankMgrController) iocAnnotationContainer.getBean("bankMgrController")).getMessages();

    }
}

