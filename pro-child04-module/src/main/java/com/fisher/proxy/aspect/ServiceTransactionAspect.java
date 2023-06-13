package com.fisher.proxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Service层 事务环绕通知
 * <br/> 使用<code>@Order</code>注解可以控制切面的优先级:
 * <br/><code>@Order</code>(较小的数) 优先级高
 * <br/><code>@Order</code>(较大的数) 优先级低<br>
 * @author fisher
 * @version 1.0.1 2023/6/11 - 13:17
 */
@Slf4j
@Aspect
@Component
public class ServiceTransactionAspect {

    /**
     * 使用@Around注解标明环绕通知方法
     * @param joinPoint 通过在通知方法形参位置声明ProceedingJoinPoint类型的形参，Spring会将这个类型的对象传入
     * @return blank
     */
    @Around(value = "com.fisher.proxy.pointcut.FisherPointCut.transactionPointCut()")
    public Object manageTransaction(ProceedingJoinPoint joinPoint){

        //获取外界调用目标方法时传入的形参数组
        Object[] args = joinPoint.getArgs();

        //获取目标方法的签名对象
        Signature signature = joinPoint.getSignature();

        //获取目标方法名
        String methodName = signature.getName();

        //声明目标方法的返回值
        Object targetMethodReturnValue = null;

        //事务流程（模拟）
        try{
            //开启事务
            log.debug("[AOP环绕通知] 开启事务,方法名："+methodName+",参数列表："+ Arrays.asList(args));

            // 通过ProceedingJoinPoint对象调用目标方法,并将目标方法的返回值传出
            targetMethodReturnValue = joinPoint.proceed(args);

            //提交事务
            log.debug("[AOP环绕通知] 提交事务,方法名："+methodName+",方法返回值："+targetMethodReturnValue);

        }catch (Throwable throwable){

            //回滚事务
            log.debug("[AOP环绕通知] 回滚事务,方法名："+methodName+",异常信息："+throwable.getClass().getName()+":"+throwable.getMessage());

        }finally {
            //释放资源
            log.debug("[AOP环绕通知] 释放数据库连接,方法名："+methodName);
        }
        //返回目标方法的返回值
        return targetMethodReturnValue;
    }
}
