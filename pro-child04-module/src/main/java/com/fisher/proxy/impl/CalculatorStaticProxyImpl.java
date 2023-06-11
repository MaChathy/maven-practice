package com.fisher.proxy.impl;

import com.fisher.proxy.api.Calculator;
import lombok.extern.slf4j.Slf4j;

/**
 * Calculator 接口的静态代理实现<br>
 * <br>
 * 关键：将代理目标声明为成员变量<br>
 * 存在问题：灵活性低
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:33
 */
@Slf4j
public class CalculatorStaticProxyImpl implements Calculator {

    /**
     * 将代理的目标声明为成员边量
     */
    private final Calculator target;

    public CalculatorStaticProxyImpl(Calculator target){
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        //代理类实现附加功能
        log.info("add方法开始，参数是："+i+","+j);

        //通过目标对象实现核心业务逻辑
        int result = target.add(i,j);

        //代理类实现附加功能
        log.info("add方法结束，结果是："+result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        //代理类实现附加功能
        log.info("sub方法开始，参数是："+i+","+j);

        //通过目标对象实现核心业务逻辑
        int result = target.sub(i,j);

        //代理类实现附加功能
        log.info("sub方法结束，结果是："+result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        //代理类实现附加功能
        log.info("mul方法开始，参数是："+i+","+j);

        //通过目标对象实现核心业务逻辑
        int result = target.mul(i,j);

        //代理类实现附加功能
        log.info("mul方法结束，结果是："+result);

        return result;
    }

    @Override
    public int div(int i, int j) {
        //代理类实现附加功能
        log.info("div方法开始，参数是："+i+","+j);

        //通过目标对象实现核心业务逻辑
        int result = target.div(i,j);

        //代理类实现附加功能
        log.info("div方法结束，结果是："+result);

        return result;
    }
}
