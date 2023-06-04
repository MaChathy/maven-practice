package com.fisher.spring.ioc.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * IoC测试类
 * v1.0.1 创建bean ,并根据bean的id获取bean对象
 * v1.1.1 获取bean ,根据bean的类型获取bean对象
 * v1.2.1 获取bean ,获取有多个类都实现了同一接口，并且这些类都装配了bean的bean对象
 * v1.3.1 给bean的属性赋值：setter注入
 * v1.4.1 给bean的属性赋值：引用外部以声明的bean
 * @author fisher
 * @version 1.4.1 2023-6-4 19:30:51
 */
@Slf4j
public class IoCTest {

    private static ApplicationContext iocContainer ;

    @Before
    public void init(){
        iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
        log.debug("****\tstart to testing...\t****");
    }

    @After
    public void clean(){
        iocContainer = null;
        log.debug("****\ttest end up...\t****");
    }

    @Test
    public void testExperiment01(){

        //根据bean标签的id，从IoC容器中获取bean，即组件对象
        HappyComponent happyComponent = (HappyComponent) iocContainer.getBean("happyComponent");

        happyComponent.doWork();
    }
    @Test
    public void testExperiment02(){
        //根据bean标签的类型，从IoC容器中获取bean，即组件对象
        //在此情景中，若多个bean标签对应同一种类型，则会抛出异常 NoUniqueBeanDefinitionException
        HappyComponent happyComponent = iocContainer.getBean(HappyComponent.class);

        happyComponent.doWork();
    }
    @Test
    public void testInterfaceImpl(){
        //获取有多个类都实现了同一接口，并且这些类都装配了bean的bean对象
        //获取失败！NoUniqueBeanDefinitionException
        ComponentInterface componentInterface1 = iocContainer.getBean(ComponentInterface.class);
        componentInterface1.doMoreWork();
    }

    @Test
    public void testExperiment03(){
        HappyComponent happyComponent3 = (HappyComponent) iocContainer.getBean("happyComponent3");
        //通过bean类型（class属性值）的方式获取bean对象的方式会报错，NoUniqueBeanDefinitionException
        //原因：applicationContext.xml配置文件中有多个同一类型的bean标签
        //HappyComponent happyComponent3 = iocContainer.getBean(HappyComponent.class);
        log.debug("componentName = "+happyComponent3.getComponentName());
    }

    @Test
    public void testExperiment04(){
        VeryHappyComponent happyComponent4 = iocContainer.getBean(VeryHappyComponent.class);

        happyComponent4.doWork();
    }

}