package com.fisher.spring.ioc.component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * ioc组件
 * v1.1.1 给组件的属性，赋值setter注入
 * @author fisher
 * @version 1.1.1 2023-6-4 19:19:42
 */
@Slf4j
@Getter
public class HappyComponent {

    private String componentName;

    public HappyComponent(){
        System.out.println("Constructing the component...");
    }

    public void doWork(){
        log.debug("component do work...");
    }

    public void happyInit(){
        log.debug("★★★HappyComponent init...★★★");
    }
    public void happyDestroy(){
        log.debug("☆☆HappyComponent destroy...☆☆");
    }

    public void setComponentName(String componentName) {
        System.out.println("Setting component name...");
        this.componentName = componentName;
    }
}
