package com.fisher.ioc.configuration;

import com.fisher.ioc.controller.BankMgrController;
import com.fisher.ioc.repository.BankMgrMapper;
import com.fisher.ioc.service.BankMgrService;
import com.fisher.proxy.api.Calculator;
import com.fisher.proxy.aspect.LogAspect;
import com.fisher.proxy.impl.CalculatorPureImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 完全注解开发
 * @author fisher
 * @version 1.0.1 2023/6/10 - 11:32
 */
@Configuration
@ComponentScan("com.fisher")
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
public class MyConfiguration {

    @Bean
    public BankMgrController getBankMgrController(){
        return new BankMgrController(getBankMgrService());
    }

    @Bean
    public BankMgrService getBankMgrService(){
        return new BankMgrService(getBankMgrMapper());
    }

    @Bean
    public BankMgrMapper getBankMgrMapper(){
        return new BankMgrMapper();
    }

}
