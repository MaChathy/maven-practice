package com.fisher.proxy.api;

import com.fisher.proxy.impl.CalculatorLogImpl;
import com.fisher.proxy.impl.CalculatorPureImpl;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Calculator接口测试类
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:24
 */
public class CalculatorTest {

    @Test
    public void testCommon(){
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        CalculatorLogImpl calculatorLog = new CalculatorLogImpl();
        calculatorPure.add(2,2);
        calculatorLog.add(1,1);
    }

}