package com.fisher.proxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Calculator接口的 日志切面类
 * @author fisher
 * @version 1.0.1 2023/6/10 - 17:32
 */
@Aspect
@Slf4j
@Component
public class LogAspect {


    //Before注解：声明当前方法是前置方法
    //value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在那个目标方法上
    @Before(value = "execution(public int com.fisher.proxy.api.Calculator.add(int,int))")
    public void printLogBeforeCore(){
        log.debug("[AOP前置通知] 方法开始...");
    }

    //After注解：声明当前方法是后置方法
    @After(value = "execution(public int com.fisher.proxy.api.Calculator.add(int,int))")
    public void printLogAfterCore(){
        log.debug("[AOP后置通知] 方法最终结束...");
    }

    @AfterReturning(value = "execution(public int com.fisher.proxy.api.Calculator.add(int,int))")
    public void printLogAfterSuccess(){
        log.debug("[AOP返回通知] 方法成功返回...");
    }

    @AfterThrowing(value = "execution(public int com.fisher.proxy.api.Calculator.add(int,int))")
    public void printLogAfterFailure(){
        log.debug("[AOP异常通知] 方法抛出异常...");
    }

}



