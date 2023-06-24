package com.fisher.practice.test;

import java.util.*;
import java.util.function.ToDoubleFunction;

/**
 * 先來先服务算法
 * @author fisher
 * @version 1.0.1 2023/6/17 - 20:33
 */
public class DispatchService {
    /** 最大任务数量*/
    private static final int MAX_TASK = 10;
    /** 秒转化毫秒的乘法因子*/
    public static final long DEFAULT = 1000L;
    /** 当前时间*/
    public static long CURRENTS ;
    /** 任务链表*/
    public static List<TaskControlBlock> taskList;
    /** 优先队列*/
    public static PriorityQueue<TaskControlBlock> priorityQueue;

    /** 初始化任务链表*/
    public static void init() {
        CURRENTS = System.currentTimeMillis();
        taskList.add(new TaskControlBlock("task1", CURRENTS +0L,6*DEFAULT));
        taskList.add(new TaskControlBlock("task2", CURRENTS +2*DEFAULT,5*DEFAULT));
        taskList.add(new TaskControlBlock("task3", CURRENTS +5*DEFAULT,3*DEFAULT));
        taskList.add(new TaskControlBlock("task4", CURRENTS +8*DEFAULT,2*DEFAULT));
        taskList.add(new TaskControlBlock("task5", CURRENTS +9*DEFAULT,4*DEFAULT));
    }

    /**
     * 先来先服务调度算法
     */
    public static void fcfService() {

        //初始化优先队列，根据arrivalTime进行排序
        priorityQueue = new PriorityQueue<>(
                //初始容量
                MAX_TASK,
                //队列中元素的比较方式
                (o1, o2) -> Math.toIntExact(o1.getArrivalTime() - o2.getArrivalTime())
        );
        //将全部任务添加到优先队列中
        priorityQueue.addAll(taskList);
        //任务投入运行
        priorityQueue.forEach(taskControlBlock->{
            //任务开始时间
            taskControlBlock.setStartTime(System.currentTimeMillis());
            taskControlBlock.run();
        });
        System.out.println("到达时间\t任务名\t开始时间\t执行时间\t结束时间\t周转时间\t带权周转时间");
    }

    /**
     * 高优先权优先调度算法
     */
    public static void priorityService(){

        priorityQueue = new PriorityQueue<>(
                //初始容量
                MAX_TASK,
                //优先权比较
                Comparator.comparingInt(TaskControlBlock::getPriority)
        );
        priorityQueue.addAll(taskList);
        //任务投入运行
        priorityQueue.forEach(taskControlBlock ->{
            //任务开始时间
            taskControlBlock.setStartTime(System.currentTimeMillis());
            taskControlBlock.run();
        });
        System.out.println("到达时间\t任务名\t开始时间\t执行时间\t结束时间\t周转时间\t带权周转时间");
    }

    /**
     * 时间片轮转调度算法
     */
    public static void roundRobinService(){

        //初始化时间片
        long aRound = 100L;
        //任务当任务链表中有任务还没执行完时循环
        while(allDone(taskList)){
            //任务投入运行
            taskList.forEach(taskControlBlock -> {
                //获取任务临时执行时间，初次获取与任务执行时间相等
                long executionTime = taskControlBlock.getTempExecutionTime();
                Runnable r = () -> {
                    //当任务临时执行时间大于时间片，且任务完成状态为false时
                    if (executionTime - aRound > 0 && !taskControlBlock.isFinished()){
                        //任务临时开始时间
                        taskControlBlock.setTempStartTime(System.currentTimeMillis());
                        //任务临时执行时间减一个时间片
                        taskControlBlock.setTempExecutionTime(executionTime-aRound);
                        try {
                            Thread.sleep(aRound);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                        taskControlBlock.setEndTime(taskControlBlock.getTempStartTime()+aRound);
                        System.out.println(taskControlBlock.getTaskName()+" 开始执行... at "+taskControlBlock.getTempStartTime()+",未完成...");
                    }//当任务完成状态为false时
                    else if(executionTime >= 0 && !taskControlBlock.isFinished()) {
                        taskControlBlock.setStartTime(CURRENTS);
                        taskControlBlock.setStartTime(Math.max(taskControlBlock.getArrivalTime(), taskControlBlock.getStartTime()));
                        try{
                            Thread.sleep(executionTime);
                        }catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                        taskControlBlock.setEndTime(System.currentTimeMillis());
                        taskControlBlock.setFinished(true);
                        System.out.println(taskControlBlock.getTaskName()+ " 结束执行... at " + taskControlBlock.getEndTime());
                        //计算任务周转时间
                        taskControlBlock.setTransferTime(taskControlBlock.getEndTime()-taskControlBlock.getArrivalTime());
                        //计算任务带权周转时间
                        taskControlBlock.setTransferTimeWithPriority(1 +
                                taskControlBlock.getTransferTime()/(double) taskControlBlock.getExecutionTime());

                    }
                };
                r.run();
            });
        }
        System.out.println("到达时间\t任务名\t开始时间\t执行时间\t结束时间\t周转时间\t带权周转时间");
    }

    /**
     * 判断任务链表中的任务是否全部完成
     * @param taskList 任务链表
     * @return boolean 没有全部完成，返回true；否则返回false
     */
    private static boolean allDone(List<TaskControlBlock> taskList){
        for(TaskControlBlock task : taskList){
            if (!task.isFinished()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算一批任务的平均周转时间或平均带权周转时间
     * @param choose 选择任务容器,"taskList"or"priorityQueue"
     * @param function 函数接口<br>
     * <code>TaskControlBlock::getTransferTime</code> or<br> <code>TaskControlBlock::getTransferTimeWithPriority</code>
     * @return double value 平均周转时间或平均带权周转时间
     */
    private static double getAverageTransfer(String choose, ToDoubleFunction<? super TaskControlBlock> function){
        String list = "taskList";
        String queue = "priorityQueue";
        double sum = 0;
        if (list.equals(choose)){
            sum = taskList.stream().mapToDouble(function).sum();
        }else if (queue.equals(choose)){
            sum = priorityQueue.stream().mapToDouble(function).sum();
        }
        return sum / (double)taskList.size();
    }

    /**
     * 打印一批任务的平均周转时间或平均带权周转时间
     * @param choose 选择任务容器,"taskList"or"priorityQueue"
     * @param function1 函数接口 <code>TaskControlBlock::getTransferTime</code>
     * @param function2 函数接口 <code>TaskControlBlock::getTransferTimeWithPriority</code>
     */
    private static void showAverageTransferTime(
            String choose,
            ToDoubleFunction<? super TaskControlBlock> function1,
            ToDoubleFunction<? super TaskControlBlock> function2){
        //计算平均周转时间
        double averageTransferTime =
                getAverageTransfer(choose,function1);
        //计算平均带权周转时间
        double averageTransferTimeWith =
                getAverageTransfer(choose,function2);
        System.out.println("平均周转时间 = " + averageTransferTime);
        System.out.println("平均带权周转时间 = " + averageTransferTimeWith);
    }

    /**
     * 任务调度算法选择菜单<br>
     * 提供上述三种调度算法,分别是：<br>
     * 1.先来先服务算法<br>
     * 2.短作业优先算法<br>
     * 3.时间轮片算法<br>
     * "-1"退出<br>
     * 用户选择不同的数字，可实现数字对应的任务调度算法<br>
     *
     * @param index 选择数，由用户直接传入或从键盘输入
     * @param read Scanner 对象
     */
    public static void menu(int index,Scanner read){

        while(index != -1){
            System.out.println("1.先来先服务调度算法\n2.短作业优先调度算法\n3.时间轮片调度算法\n\"-1\"退出");
            System.out.println("Please choose a service:");
            index = read.nextInt();
            //初始化任务链表
            taskList = new LinkedList<>();
            //任务链表赋值
            init();
            switch (index){
                case 1:
                    fcfService();
                    priorityQueue.forEach(System.out::println);
                    showAverageTransferTime(
                            "priorityQueue",
                            TaskControlBlock::getTransferTime,
                            TaskControlBlock::getTransferTimeWithPriority);
                    break;
                case 2:
                    priorityService();
                    DispatchService.priorityQueue.forEach(System.out::println);
                    showAverageTransferTime(
                            "priorityQueue",
                            TaskControlBlock::getTransferTime,
                            TaskControlBlock::getTransferTimeWithPriority);
                    break;
                case 3:
                    roundRobinService();
                    taskList.forEach(System.out::println);
                    showAverageTransferTime(
                            "taskList",
                            TaskControlBlock::getTransferTime,
                            TaskControlBlock::getTransferTimeWithPriority);
                    break;
                default:break;
            }
        }
    }
}