package com.fisher.proxy.api;

/**
 * AOP 使用接口
 * @author fisher
 * @version 1.0.1 2023/6/10 - 14:12
 */
public interface Calculator {
    /**
     * 简单加法计算
     * @param i int
     * @param j int
     * @return i + j int
     */
    int add(int i,int j);
    /**
     * 简单减法计算
     * @param i int
     * @param j int
     * @return i - j int
     */
    int sub(int i,int j);
    /**
     * 简单乘法计算
     * @param i int
     * @param j int
     * @return i * j int
     */
    int mul(int i,int j);
    /**
     * 简单除法计算
     * @param i int
     * @param j int
     * @return i / j int
     */
    int div(int i,int j);

}
