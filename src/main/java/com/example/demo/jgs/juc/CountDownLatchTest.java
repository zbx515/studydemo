package com.example.demo.jgs.juc;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {
        Thread[] ts = new Thread[10];
        CountDownLatch countDownLatch = new CountDownLatch(ts.length);
        for(int i=0;i<ts.length;i++){
            int finalI = i;
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toSeconds(2));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第" + finalI + "个线程执行完了");
                    countDownLatch.countDown();
                }
            });
        }
        for(int i=0;i<ts.length;i++){
            ts[i].start();
        }
        try {
            System.out.println("等待子线程执行");
            countDownLatch.await();
            System.out.println("所有子线程执行完毕");
            System.out.println("执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void test(){

    }
}
