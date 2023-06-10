package com.fisher.proxy.api;

/**
 * AOP 使用接口
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:12
 */
public interface Calculator {
    //加
    int add(int i,int j);
    //减
    int sub(int i,int j);
    //乘
    int mul(int i,int j);
    //除
    int div(int i,int j);

}
