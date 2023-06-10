package com.fisher.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * 动态代理，生产代理对象的工厂类<br>
 * <br>
 * 泛型T要求是目标对象实现的接口类型<br>
 * 关键：反射技术
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:48
 */
@Slf4j
public class LogDynamicProxyFactory<T> {

    //将代理的目标对象声明为成员变量
    private final T target;

    public LogDynamicProxyFactory(T target) {
        this.target = target;
    }

    public T getProxy() {

        //创建代理对象所需参数一：获取类加载器对象
        ClassLoader targetClassLoader = target.getClass().getClassLoader();

        //创建代理对象所需参数二：目标对象的类所实现的所有接口组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler handler = (
                //代理对象
                Object proxy,
                //目标方法的Method对象
                Method method,
                //外部调用目标方法时传入的实际参数
                Object[] args    )-> {
            //InvocationHandler接口中的invoke()方法的实现就是调用目标方法
            //围绕目标方法的调用，添加附加功能

            //储存目标方法的返回值
            Object targetMethodReturnValue = null;

            //通过method对象获取方法名
            String methodName = method.getName();

            //将参数数组转化为List
            List<Object> argsList = Arrays.asList(args);
            try{
                //目标方法执行前打印日志
                log.debug("[动态代理] " + methodName + "方法开始，参数是：" + argsList);

                //调用目标方法
                targetMethodReturnValue = method.invoke(target, args);

                log.debug("[动态代理] " + methodName + "方法结束，返回值是：" + targetMethodReturnValue);
            }catch (Exception e){

                String exceptionName = e.getClass().getName();

                String message = e.getMessage();
                //在发生异常时打印异常信息
                log.debug("[动态代理] " + methodName + "方法抛出异常，异常信息是：" + exceptionName+","+message);

            }finally {
                log.debug("[动态代理] "+methodName+"方法最终结束...");
            }

            //返回目标方法的返回值
            return targetMethodReturnValue;
        };

        @SuppressWarnings("unchecked")
        T proxy = (T) Proxy.newProxyInstance(targetClassLoader,interfaces,handler);

        return proxy;
    }
}
