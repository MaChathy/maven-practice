package com.fisher.proxy.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 重用切入点表达式
 * @author fisher
 * @version 1.0.1 2023/6/10 - 20:21
 */
@Component
public class FisherPointCut {

    @Pointcut(value = "execution(public int *..Calculator.sub(int,int))")
    public void fisherGlobalPointCut(){
    }

    @Pointcut(value = "execution(public int *..Calculator.add(int,int))")
    public void fisherSecondaryPointCut(){

    }

    @Pointcut(value = "execution(* *..*Service.*(..))")
    public void transactionPointCut(){

    }
}
