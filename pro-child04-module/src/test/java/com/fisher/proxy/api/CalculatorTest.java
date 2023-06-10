package com.fisher.proxy.api;

import com.fisher.proxy.LogDynamicProxyFactory;
import com.fisher.proxy.impl.CalculatorLogImpl;
import com.fisher.proxy.impl.CalculatorPureImpl;
import com.fisher.proxy.impl.CalculatorStaticProxyImpl;
import com.fisher.proxy.impl.SoldierServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Calculator接口测试类<br>
 * v1.0.1 测试Calculator的日志实现<br>
 * v1.1.1 测试Calculator的静态代理实现<br>
 * v1.2.1 测试Calculator的动态代理实现<br>
 *
 * @author fisher
 * @version 1.2.1 2023-6-10 15:19:35
 */
@Slf4j
public class CalculatorTest {

    @Test
    public void testCommon(){
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        CalculatorLogImpl calculatorLog = new CalculatorLogImpl();
        calculatorPure.add(2,2);
        calculatorLog.add(1,1);
    }

    @Test
    public void testStaticProxy(){
        CalculatorStaticProxyImpl staticProxy = new CalculatorStaticProxyImpl(new CalculatorPureImpl());
        staticProxy.add(4,4);
    }

    @Test
    public void testDynamicProxy(){

        Calculator target = new CalculatorPureImpl();

        LogDynamicProxyFactory<Calculator> dynamicProxyFactory = new LogDynamicProxyFactory<>(target);

        Calculator proxy = dynamicProxyFactory.getProxy();

        proxy.add(1,1);
        proxy.div(4,1);

    }
    @Test
    public void testDynamicProxy2(){

        //创建被代理的目标对象
        SoldierService target = new SoldierServiceImpl();

        //创建生产代理兑现的工厂
        LogDynamicProxyFactory<SoldierService> proxyFactory = new LogDynamicProxyFactory<>(target);

        //生产代理对象
        SoldierService proxy = proxyFactory.getProxy();

        //通过代理对象调用目标方法
        String soldierNameById = proxy.getSoldierNameById(null);
        log.debug("getSoldierNameById = "+ soldierNameById );

    }

}