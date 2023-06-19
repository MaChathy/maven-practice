package com.fisher.practice.test;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static com.fisher.practice.test.DispatchService.*;

/**
 * 测试类
 * @author fisher
 * @version 1.0.1 2023/6/18 - 14:01
 */
public class DispatchServiceTest {

    @Test
    public void testFjfService(){
        fcfService();
        System.out.println("到达时间\t任务名\t开始时间\t执行时间\t结束时间");
    }

    @Test
    public void testSjfService(){
        priorityService();
        System.out.println("到达时间\t任务名\t开始时间\t执行时间\t结束时间");
    }

    @Test
    public void testTimeRound(){
        roundRobinService();
        System.out.println("到达时间\t任务名\t开始时间\t执行时间\t结束时间\t周转时间\t带权周转时间");
        taskList.forEach(System.out::println);
    }

    @Test
    public void testMenu() {
        Scanner read = new Scanner(System.in);
        menu(0,read);
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        menu(0,read);
    }

}
