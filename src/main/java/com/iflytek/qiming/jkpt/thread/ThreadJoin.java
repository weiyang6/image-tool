package com.iflytek.qiming.jkpt.thread;

/**
* @ClassName ThreadJoin
* @Description TODO
* @Author weiyang
* @Date 2019/10/23 21:41
* @Version 1.0
**/
class ThreadJoin extends Thread{

    @Override
   public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x);
            //Thread.yield();
        }
   }
}
