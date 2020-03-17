package com.iflytek.qiming.jkpt.execute;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CyclicBarrierDemo
 * @Description TODO
 * @Author weiyang
 * @Date 2019/10/20 23:08
 * @Version 1.0
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args){
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i = 0; i < threadNum; i++) {
            executorService.submit(new TaskThread(barrier));
        }
    }
}



class TaskThread implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public TaskThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+ " 到达栅栏 A");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " 冲破栅栏 A");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}