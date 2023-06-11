package com.fisher.proxy.impl;

import com.fisher.proxy.api.Calculator;
import com.fisher.proxy.api.SoldierService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AOP测试类<br>
 * <br> v1.0.1 基于注解"@Aspect"的AOP
 * <br> v1.1.1 重用切入点测试
 * @author fisher
 * @version 1.1.1 2023-6-11 13:09:39
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class CalculatorPureImplTest {

    @Autowired
    @Qualifier(value = "annotationAOP")
    private Calculator calculator;

    @Autowired
    @Qualifier(value = "outDeclarePointCut")
    private SoldierService soldierService;


    @Test
    public void testAnnotationAOP(){

        int result = calculator.div(1,1);

        log.debug("方法外部 div = " + result);
    }

    @Test
    public void testInnerDeclarePointCut(){
        int addResult = calculator.add(1, 1);
        log.debug("方法外部 add = "+addResult);

        int mulResult = calculator.mul(2, 2);
        log.debug("方法外部 mul = "+mulResult);
    }

    @Test
    public void testOutDeclarePointCut(){
        soldierService.getSoldierNameById(1);
        calculator.mul(1,4);
    }
}