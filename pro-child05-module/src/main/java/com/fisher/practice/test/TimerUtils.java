package com.fisher.practice.test;

/**
 * 时间工具类
 * @author fisher
 * @version 1.0.1 2023/6/18 - 13:59
 */
public class TimerUtils{
    /**
     * 取毫秒计数单位的后5位
     * @param time 毫秒
     * @return time的后5位
     */
    static long transfer(long time){
        int pow = 5;
        long sum = 0;
        for (int i = 0; i < pow; i++) {
            long dev = (long) Math.pow(10,i);
            sum += time/dev%10L*dev;
        }
        return sum;
    }
}