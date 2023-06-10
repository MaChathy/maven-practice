package com.fisher.proxy.impl;

import com.fisher.proxy.api.Calculator;

/**
 * Calculator 接口的纯净实现
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:15
 */
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;

        System.out.println("add方法内部 result = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;

        System.out.println("sub方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;

        System.out.println("mul方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;

        System.out.println("div方法内部 result = " + result);

        return result;
    }
}
