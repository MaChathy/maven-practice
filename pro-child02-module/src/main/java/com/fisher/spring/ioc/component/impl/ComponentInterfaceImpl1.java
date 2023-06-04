package com.fisher.spring.ioc.component.impl;

import com.fisher.spring.ioc.component.ComponentInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * 实现接口的组件
 * @author fisher
 * @version 1.0.1 2023/6/4 - 18:58
 */
@Slf4j
public class ComponentInterfaceImpl1 implements ComponentInterface {

    @Override
    public void doMoreWork(){
        log.debug(doWork()+" componentInterfaceImpl1 do work...");
    }
}
