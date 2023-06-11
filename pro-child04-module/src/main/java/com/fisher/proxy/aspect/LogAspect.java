package com.fisher.proxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Calculator接口的 日志切面类
 * <br>v1.0.1 通过注解的aspect
 * <br>v1.1.1 各个通知获取详细信息
 * @author fisher
 * @version 1.1.1 2023-6-10 19:42:43
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    /**
     * Before注解：声明当前方法是前置方法<br>
     *     <br>value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在那个目标方法上
     * @param joinPoint 切入点
     */
    @Before(value = "execution(public int com.fisher.proxy.api.Calculator.div(int,int))")
    public void printLogBeforeCore(JoinPoint joinPoint){
        //通过JoinPoint对象获取目标方法的签名对象，即一个方法的全部信息
        Signature signature = joinPoint.getSignature();
        //通过方法的签名对象获取目标方法的全部信息
        String methodName = signature.getName();
        System.out.println("methodName = " + methodName);

        int modifiers = signature.getModifiers();
        System.out.println("modifiers = " + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName = " + declaringTypeName);

        //通过JoinPoint对象获取外界调用目标方法时传入的实参列表
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        log.debug("[AOP前置通知] "+ methodName +"方法开始,参数为："+argsList);
    }

    /**
     * After注解：声明当前方法是后置方法
     * @param joinPoint 切入点
     */
    @After(value = "execution(public int com.fisher.proxy.api.Calculator.div(int,int))")
    public void printLogAfterCore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.debug("[AOP后置通知]"+methodName+"方法最终结束...");
    }

    /**
     * AfterReturning注解：标记返回通知方法<br/>
     *     <br>在返回通知中获取目标方法返回值分为两步：<br/>
     *     1.在@AfterReturning注解中通过returning属性设置一个名称<br/>
     *     2.使用returning属性设置的名称在通知方法中声明一个对应的参数
     * @param joinPoint 切入点
     * @param targetMethodReturnValue 方法返回值
     */
    @AfterReturning(
            value = "execution(public int com.fisher.proxy.api.Calculator.div(int,int))",
            returning = "targetMethodReturnValue"
    )
    public void printLogAfterSuccess(JoinPoint joinPoint,Object targetMethodReturnValue){
        String methodName = joinPoint.getSignature().getName();
        log.debug("[AOP返回通知]"+methodName+"方法成功返回,返回值："+targetMethodReturnValue);
    }

    /**
     * AfterThrowing注解：标记异常通知方法
     * @param joinPoint 切入点
     * @param targetMethodException 方法抛出的异常
     */
    @AfterThrowing(
            value = "execution(public int com.fisher.proxy.api.Calculator.div(int,int))",
            throwing = "targetMethodException"
    )
    public void printLogAfterFailure(JoinPoint joinPoint,Throwable targetMethodException){
        String methodName = joinPoint.getSignature().getName();
        log.debug("[AOP异常通知]"+methodName+" 方法抛出异常,异常信息："+targetMethodException.getClass()+": "+targetMethodException.getMessage());
    }

}



