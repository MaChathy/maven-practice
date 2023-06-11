package com.fisher.bankmgr.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 模拟银行家算法
 * @author fisher
 * @version 1.0.1 2023/5/30 - 21:47
 */
public class BankerAlgorithm {

    //进程数量
    static final int PCOUNT = 5;
    //资源数量
    static final int RCOUNT = 4;

    //进程最多持有资源
    static int[][] maxNeed ;
    //进程已持有资源
    static int[][] hand ;
    //进程资源需求
    static int[][] need ;
    //银行剩余资源
    static int[] rest ;
    //进程请求资源
    static int[] request;
    //某时刻银行剩余资源
    static int[] tempRest ;
    //是否获取全部资源
    static boolean[] isSatisfied ;

    //存放安全序列数组
    static int[] safety = new int[5];

    //初始化
    static void init(){
        maxNeed = new int[][]{
                {0,0,1,2},
                {1,7,5,0},
                {2,3,5,6},
                {0,6,5,2},
                {0,6,5,6}
        };
        hand = new int[][]{
                {0,0,1,2},
                {1,0,0,0},
                {1,3,5,4},
                {0,6,3,2},
                {0,0,1,4},
        };
        rest = new int[]{1,5,2,0};
        request = new int[RCOUNT];
        tempRest = new int[RCOUNT];
        isSatisfied = new boolean[PCOUNT];
        need = getNeed();
    }

    //获取线程需求矩阵
    static int[][] getNeed(){
        int[][] need = new int[PCOUNT][RCOUNT];
        for (int i = 0; i < PCOUNT; i++) {
            for (int j = 0; j < RCOUNT; j++) {
                need[i][j] = maxNeed[i][j]-hand[i][j];
            }
        }
        return need;
    }

    //打印显示信息
    static void showMsg(){
        System.out.println("—————————————————————————————————————————————————————");
        System.out.println("进程\t以分配资源\t最大需求数\t资源需求数\t  是否完成");
        System.out.println("—————————————————————————————————————————————————————");
        System.out.println("XX\t|A B C D|\t|A B C D|\t|A B C D|\t |true\\false|");
        System.out.println("—————————————————————————————————————————————————————");
        for (int i = 0; i < PCOUNT; i++) {
            System.out.println("p"+i+"\t|"+Arrays.toString(hand[i]).replace(", ", " ").substring(1,8)+"|\t|"
                    + Arrays.toString(maxNeed[i]).replace(", "," ").substring(1,8)+"|\t|"
                    + Arrays.toString(need[i]).replace(", "," ").substring(1,8)+"|\t|\t"
                    +isSatisfied[i]+"\t|");
            System.out.println("—————————————————————————————————————————————————————");
        }
        System.out.println("资源剩余数");
        System.out.print("|A|B|C|D|\n|");
        for (int i = 0; i < RCOUNT; i++) {
            System.out.print(rest[i]+"|");
        }
        System.out.println();
    }

    //判断是否处于安全状态，若是返回true，否则返回false
    static boolean isSafe(){
        System.arraycopy(rest, 0, tempRest, 0, RCOUNT);
        int index = 0;

        for (int i = 0; i < PCOUNT; i++) {
            int validResCount = 0;
            for (int j = 0; j < RCOUNT; j++) {
                if (!isSatisfied[i] && need[i][j] <= tempRest[j]){
                    validResCount++;
                }
                if (validResCount == RCOUNT){
                    System.arraycopy(hand[i],0, request,0,RCOUNT);
                    request = Arrays.copyOf(hand[i],RCOUNT);
                    for (int k = 0; k < RCOUNT; k++) {
                        tempRest[k] += request[k];
                    }
                    isSatisfied[i] = true;
                    need[i] = new int[]{0,0,0,0};
                    hand[i] = new int[]{0,0,0,0};
                    safety[index++] = i;

                    i=-1;
                }
            }
        }
        for (int i = 0; i < RCOUNT; i++) {
            if (!isSatisfied[i]) {
                return false;
            }
        }

        return true;
    }

    //尝试分配资源
    static void tryResponse(int i){

        for (int j = 0; j < RCOUNT; j++) {
            rest[j] -= request[j];
            hand[i][j] += request[j];
        }
        need = getNeed();
    }

    //回滚已分配的资源，与尝试分配资源操作相反
    static void rollback(int i){
        for (int j = 0; j < RCOUNT; j++) {
            rest[j] += request[j];
            hand[i][j] -= request[j];
        }
        need = getNeed();
    }

    //请求是否合理
    static boolean validRequest(){
        for (int i = 0; i < RCOUNT; i++) {
            if (request[i] > rest[i]){
                return false;
            }
        }
        return true;
    }

    //可以回应线程请求
    static boolean canResponse(int index){
        if (validRequest()) {
            tryResponse(index);
            if (!isSafe()){
                rollback(index);
                return false;
            }
        }else {
            System.out.println("请求不合理!");
            return false;
        }

        return true;
    }

    /**
     * 测试_1:判断银行现在是否处于安全状态
     */
    @Test
    public void testIsSafe(){
        init();
        showMsg();
        if(isSafe()){
            System.out.println("处于安全装态...");
            System.arraycopy(tempRest,0,rest,0,RCOUNT);
            System.out.println("安全序列是："+Arrays.toString(safety));
        }else {
            System.out.println("不处于安全状态");
        }
        showMsg();
    }

    /**
     * 测试_2:是否可以满足p1提出需要(0,4,2,0)个资源的请求
     */
    @Test
    public void testCanResponse(){
        init();
        showMsg();
        request = new int[]{0,4,2,0};

        boolean canResponse = canResponse(1);
        if(canResponse){
            System.out.println("可以满足请求");
            System.arraycopy(tempRest,0,rest,0,RCOUNT);
            System.out.println("安全序列是："+Arrays.toString(safety));
        }else {
            System.out.println("不能满足请求......");
        }

        showMsg();
    }
}
