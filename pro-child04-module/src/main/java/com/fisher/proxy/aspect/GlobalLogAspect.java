package com.fisher.proxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 全局 日志切面类
 * @author fisher
 * @version 1.0.1 2023/6/11 - 12:00
 */
@Aspect
@Slf4j
@Component
public class GlobalLogAspect {

    @Before(value = "com.fisher.proxy.pointcut.FisherPointCut.fisherGlobalLogPointCut()")
    public void serviceCoreBeforeLog(JoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();

        String name = signature.getName();

        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName = " + declaringTypeName);

        int modifiers = signature.getModifiers();
        System.out.println("modifiers = " + modifiers);

        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        String msg = "[AOP前置通知]"+name+"方法开始,参数："+argsList;
        log.debug(msg);
    }

    @After(value = "com.fisher.proxy.pointcut.FisherPointCut.fisherGlobalLogPointCut()")
    public void serviceCoreAfterLog(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.debug("[AOP后置通知]"+methodName+"方法结束");
    }


    @AfterReturning(
            value = "com.fisher.proxy.pointcut.FisherPointCut.fisherGlobalLogPointCut()",
            returning = "targetReturnValue")
    public void serviceCoreAfterReturnLog(JoinPoint joinPoint, Object targetReturnValue){
        String methodName = joinPoint.getSignature().getName();

        log.debug("[AOP返回通知]"+methodName+"方法返回值,返回值："+targetReturnValue);
    }

    @AfterThrowing(value = "com.fisher.proxy.pointcut.FisherPointCut.fisherGlobalLogPointCut()",
            throwing = "targetThrowableException")
    public void serviceCoreAfterThrowingLog(JoinPoint joinPoint,Throwable targetThrowableException){
        String methodName = joinPoint.getSignature().getName();

        log.debug("[AOP异常通知]"+methodName+"方法抛出异常,异常信息："+targetThrowableException.getClass()+":"+ targetThrowableException.getMessage());
    }
}
