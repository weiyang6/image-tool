package com.iflytek.qiming.jkpt.execute;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDownLatchDemo
 * @Description TODO
 * @Author weiyang
 * @Date 2019/10/17 23:27
 * @Version 1.0
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        ExecutorService pool=Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(100);
         for(int i=0;i<100;i++){
             pool.submit(new CountRunable(countDownLatch));
         }
    }
}



class CountRunable implements  Runnable{
private CountDownLatch countDownLatch;

    public CountRunable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
          //每次减少一个线程
        countDownLatch.countDown();
        System.out.println("thread counts = " + (countDownLatch.getCount()));

        //等待执行,等待被唤醒
        try {
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}