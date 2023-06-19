package com.fisher.practice.test;

import lombok.Getter;
import lombok.Setter;

/**
 * 任务控制块
 * @author fisher
 * @version 1.0.1 2023/6/18 - 13:57
 */
@Setter
@Getter
public class TaskControlBlock implements Runnable{
    /** 任务名*/
    private String taskName;
    /** 到达时间*/
    private long arrivalTime;
    /** 执行时间*/
    private long executionTime;
    /** 临时执行时间*/
    private long tempExecutionTime;
    /** 开始时间*/
    private long startTime;
    /** 临时开始时间*/
    private long tempStartTime;
    /** 结束时间*/
    private long endTime;
    /** 周转时间*/
    private double transferTime;
    /** 带权周转时间*/
    private double transferTimeWithPriority;
    /** 是否完成*/
    private boolean finished;
    /** 优先权*/
    private int priority;


    public TaskControlBlock(String taskName,long arrivalTime, long executionTime) {
        this.taskName = taskName;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.tempExecutionTime = executionTime;
        //任务优先级由执行时间决定
        this.priority = Math.abs(Math.toIntExact(executionTime));
    }


    @Override
    public String toString() {
        return TimerUtils.transfer(arrivalTime) + "\t" +
                taskName + "\t" +
                TimerUtils.transfer(startTime) +"\t"+
                TimerUtils.transfer(executionTime) + "\t" +
                TimerUtils.transfer(endTime) + "\t" +
                transferTime + "\t" + transferTimeWithPriority;
    }

    @Override
    public void run() {

        //获取开始执行时间
        startTime = Math.max(arrivalTime, startTime);
        System.out.println(taskName+" 开始执行... at "+startTime);
        try {
            //模拟任务执行
            Thread.sleep(executionTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //获取结束时间
        endTime = startTime + executionTime;
        //任务完成状态色置为true
        this.finished = true;
        //计算任务周转时间
        transferTime = endTime - arrivalTime;
        //计算任务带权周转时间
        transferTimeWithPriority = 1 + transferTime/(double) executionTime;
        System.out.println(taskName+ " 结束执行... at " + endTime);

    }
}
