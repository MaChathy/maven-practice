package com.fisher.proxy.impl;

import com.fisher.proxy.api.Calculator;
import lombok.extern.slf4j.Slf4j;

/**
 * Calculator 接口的日志实现
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:20
 */
@Slf4j
public class CalculatorLogImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        log.info("add方法开始，参数是："+i+","+j);

        int result = i + j;
        System.out.println("add方法内部 result = " + result);

        log.info("add方法结束，结果是："+result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        log.info("sub方法开始，参数是："+i+","+j);

        int result = i - j;
        System.out.println("sub方法内部 result = " + result);

        log.info("sub方法结束，结果是："+result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        log.info("mul方法开始，参数是："+i+","+j);

        int result = i * j;
        System.out.println("mul方法内部 result = " + result);

        log.info("mul方法结束，结果是："+result);

        return result;
    }

    @Override
    public int div(int i, int j) {
        log.info("div方法开始，参数是："+i+","+j);

        int result = i / j;
        System.out.println("div方法内部 result = " + result);

        log.info("div方法结束，结果是："+result);

        return result;
    }
}
