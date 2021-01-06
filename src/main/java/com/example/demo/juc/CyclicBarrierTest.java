package com.example.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierTest {

    /**
     * 用于协调一组线程
     * CyclicBarrier 的用法类似于CountDownLatch。区别在于
     * CyclicBarrier是线程之间自行相互等待，直到所有的线程到达后才执行下一步
     * 可循环使用，满员之后释放，可重新开始
     */

    public static void main(String[] args) {
        //初始化三个
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            //所有任务完成后的回调
            @Override
            public void run() {
                System.out.println("所有任务已执行完成");
            }
        });
        //t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //第一个线程在等待
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        //t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //第二个线程在等待
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
        try {
            //第三个线程在等待
            cyclicBarrier.await();
            System.out.println("主线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
