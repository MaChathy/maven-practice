package com.fisher.spring.ioc.component;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.fisher.spring.controller.HappyController;
import com.fisher.spring.ioc.factory.HappyFactoryBean;
import com.fisher.spring.service.HappyService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;


/**
 * IoC测试类
 * v1.0.1 创建bean ,并根据bean的id获取bean对象
 * v1.1.1 获取bean ,根据bean的类型获取bean对象
 * v1.2.1 获取bean ,获取有多个类都实现了同一接口，并且这些类都装配了bean的bean对象
 * v1.3.1 给bean的属性赋值：setter注入
 * v1.4.1 给bean的属性赋值：引用外部以声明的bean
 * v1.5.1 给bean的属性赋值：内部bean
 * v1.6.1 给bean的属性赋值：引入外部属性文件
 * v1.7.1 给bean的属性赋值：构造器注入
 * v1.8.1 给bean的属性赋值：特殊值处理
 * v1.9.1 给bean的属性赋值：使用p名称空间（省略标签property）
 * v1.9.2 给bean的属性赋值：集合属性
 * v1.9.3 给bean的属性赋值：自动装配
 * v1.9.4 集合类型的bean
 * v1.9.5 FactoryBean 机制
 * v1.9.6 bean的作用域
 * v1.9.7 bean的生命周期
 * @author fisher
 * @version 1.9.7 2023-6-5 17:08:18
 */
@Slf4j
public class IoCTest {

    private static ApplicationContext iocContainer ;

    @Before
    public void init(){
        iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
        log.debug("****\tstart to testing...\t****");
//        log.debug("★☆★☆★");
    }
//    @After
//    public void clean(){
//        iocContainer = null;
//        log.debug("****\ttest end up...\t****");
//    }

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
    @Test
    public void testExperiment05(){
        VeryHappyComponent happyComponent5 = (VeryHappyComponent) iocContainer.getBean("happyComponent5");

        happyComponent5.doWork();

    }
    @Test
    public void testExperiment06() throws SQLException {
        DruidDataSource druidDataSource = (DruidDataSource) iocContainer.getBean("druidDataSource");

        DruidPooledConnection connection = druidDataSource.getConnection();

        log.debug("DruidPooledConnection = "+connection);

        connection.close();
        druidDataSource.close();

    }
    @Test
    public void testExperiment07(){
        VeryHappyComponent happyComponent7 = (VeryHappyComponent) iocContainer.getBean("happyComponent7");

        happyComponent7.doWork();

        String happyMachineName = happyComponent7.getHappyMachine().getHappyMachineName();

        log.debug("happyMachineName: " + happyMachineName);

    }
    @Test
    public void testExperiment08(){
        HappyTeam bean = iocContainer.getBean(HappyTeam.class);

        log.debug(bean.toString());
    }
    @Test
    public void testExperiment09(){
        PropValue propValue = (PropValue) iocContainer.getBean("propValue");

        log.debug("expression : "+ propValue.getExpression());

        log.debug("commonValue : "+propValue.getCommonValue());
    }
    @Test
    public void testExperiment10(){
        PropValue propValue1 = (PropValue) iocContainer.getBean("propValue1");
        log.debug(propValue1.toString());
    }
    @Test
    public void testExperiment11(){
        HappyTeam happyTeam2 = (HappyTeam) iocContainer.getBean("happyTeam2");

        log.debug("members : "+happyTeam2.getMemberList().toString());

    }
    @Test
    public void testExperiment12(){
        HappyController happyController = iocContainer.getBean(HappyController.class);

        HappyService happyService = happyController.getHappyService();

        log.debug("happyService : "+happyService);
    }

    @Test
    public void testExperiment13(){
        @SuppressWarnings("unchecked")
        List<HappyMachine> machineList = (List<HappyMachine>) iocContainer.getBean("machineList");

        for(var machine : machineList){
            log.debug("machines contain : "+machine.getHappyMachineName());
        }

    }

    @Test
    public void testExperiment14(){
        HappyMachine happyMachine = iocContainer.getBean(HappyFactoryBean.class);

        log.debug("HappyMachine : "+ happyMachine.getHappyMachineName());
    }

    @Test
    public void testExperiment15(){
        HappyMachine happyMachine01 = (HappyMachine) iocContainer.getBean("happyMachine4");
        HappyMachine happyMachine02 = (HappyMachine) iocContainer.getBean("happyMachine4");

        log.debug(String.valueOf(happyMachine01 == happyMachine02));
        log.debug(String.valueOf(happyMachine01.equals(happyMachine02)));

        log.debug("happyMachine1: " + happyMachine01.hashCode());
        log.debug("happyMachine2: " + happyMachine02.hashCode());
    }

    @Test
    public void testExperiment16(){
        HappyComponent happyComponent = (HappyComponent) iocContainer.getBean("happyComponentLife");
        happyComponent.doWork();
    }
}