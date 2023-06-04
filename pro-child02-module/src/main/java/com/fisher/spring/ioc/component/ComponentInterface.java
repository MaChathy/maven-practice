package com.fisher.spring.ioc.component;

/**
 * 组件接口
 * @author fisher
 * @version 1.0.1 2023/6/4 - 18:55
 */
public interface ComponentInterface {

    default String doWork(){
        return ("**Implementing the ComponentInterface**");
    }

    void doMoreWork();

}
