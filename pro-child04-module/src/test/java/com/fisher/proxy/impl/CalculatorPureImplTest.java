package com.fisher.proxy.impl;

import com.fisher.ioc.configuration.MyConfiguration;
import com.fisher.proxy.api.Calculator;
import com.fisher.proxy.aspect.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AOP测试类<br>
 * <br> v1.0.1 基于注解"@Aspect"的AOP
 * @author fisher
 * @version 1.0.1 2023/6/10 - 17:43
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class CalculatorPureImplTest {

    @Autowired
    @Qualifier(value = "test1")
    private Calculator calculator;

    @Test
    public void testAnnotationAOP(){

        int result = calculator.add(1,1);

        log.debug("");
    }
}