package com.iflytek.qiming.jkpt.thread;



import java.io.IOException;

public class DaemonThread {
    public static void main(String[] args) throws IOException {
        Thread mainThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("线程 1 第" + i + "次执行！");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread daemonThread = new Thread(() -> {
            for (long i = 0; i < 10000; i++) {
                System.out.println("后台线程第" + i + "次执行！");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true); //设置为守护线程
        daemonThread.start();
        mainThread.start();



        Thread ts = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("睡觉中...");
            }
            System.out.println("我醒啦");
        });
        ts.start();
        try {
            Thread.sleep(1000);
            // ts.stop();
            System.out.println("别睡了，起来嗨");
            ts.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

