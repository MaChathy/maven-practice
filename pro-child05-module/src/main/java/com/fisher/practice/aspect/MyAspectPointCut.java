package com.fisher.practice.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切入点表达式
 * @author fisher
 * @version 1.0.1 2023/6/14 - 11:39
 */
@Component
public class MyAspectPointCut {

    @Pointcut(value = "execution(public * *..*Service.*(..))")
    public void serviceLogAspect(){}

}
