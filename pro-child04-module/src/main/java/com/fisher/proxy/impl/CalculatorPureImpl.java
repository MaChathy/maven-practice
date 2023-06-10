package com.fisher.proxy.impl;

import com.fisher.proxy.api.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Calculator 接口的纯净实现<br>
 * <br>v1.1.1 基于注解的AOP,放入IoC容器中。
 * @author fisher
 * @version 1.1.1 2023-6-10 17:29:37
 */
@Slf4j
@Component(value = "test1")
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;

        log.debug("add方法内部 result = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;

        log.debug("sub方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;

        log.debug("mul方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;

        log.debug("div方法内部 result = " + result);

        return result;
    }
}
