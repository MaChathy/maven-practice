package com.fisher.spring.ioc.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * HappyComponent 对应的bean组件的后置处理器类
 * 自定义的bean后置处理器
 * 针对IoC容器中的所有bean都会执行
 *
 * @author fisher
 * @version 1.0.1 2023/6/5 - 18:00
 */
public class MyHappyBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("#before#"+"beanName = " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("*after*"+"beanName = " + bean);
        return bean;
    }

}
