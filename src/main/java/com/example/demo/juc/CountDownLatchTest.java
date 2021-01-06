package com.example.demo.juc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTest {

    /**
     * 关于CountDownLatch的理解：
     * 当有一个主任务，需要等待其他多个子任务都执行完以后才能执行，就可以使用该类
     * 假如有5个子任务 让 CountDownLatch countDownLatch = new CountDownLatch(5);
     * 在主任务中调用countDownLatch.await()方法，主任务便会在此等待所有子任务执行完成后进行下一步
     * 每个子任务在执行完以后调用 countDownLatch.countDown() 会让countDownLatch-1，当所有子任务执行完毕
     * 也就是countDownLatch=0时，主任务执行下一步
     */
    private  static AtomicInteger count= new AtomicInteger(0);
    ///使用CountDownLatch模拟同时多个请求
    static class InTest implements Runnable{

        private CountDownLatch countDownLatch;
        private CountDownLatch countDownLatch2;
        public InTest(CountDownLatch countDownLatch,CountDownLatch countDownLatch2){
            this.countDownLatch= countDownLatch;
            this.countDownLatch2= countDownLatch2;
        }
        //累加10000次
        @Override
        public void run() {
            int i=0;
            try {
                //保证所有线程初始化完成后进行下一步
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(i<10000){
                count.incrementAndGet();
                i++;
            }
            //保证当前线程的任务执行完成
            countDownLatch2.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
        /*int num=1000;
        LinkedList<Object> objects = new LinkedList<>();


        CountDownLatch countDownLatch = new CountDownLatch(num);
        CountDownLatch countDownLatch2 = new CountDownLatch(num);
        ExecutorService threadPool = Executors.newFixedThreadPool(num);
        while(num>0){
            threadPool.submit(new InTest(countDownLatch,countDownLatch2));
            //保证所有线程都初始化后，再执行模拟并发
            countDownLatch.countDown();
            num--;
        }
        //保证所有线程的任务都完成
        countDownLatch2.await();
        System.out.println(count);
        threadPool.shutdown();*/
    }



    //基本用法测试
    public static void test() {
        //初始化一个countDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(2);

        //开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " 正在执行...");
                    Thread.sleep(TimeUnit.SECONDS.toSeconds(2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 执行完成");
                countDownLatch.countDown();
            }
        }, "t1").start();
        //开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " 正在执行...");
                    Thread.sleep(TimeUnit.SECONDS.toSeconds(2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 执行完成");
                countDownLatch.countDown();
            }
        }, "t2").start();

        //主线程
        try {
            System.out.println("等待子线程执行完成...");
            countDownLatch.await();
            System.out.println("子线程执行完成...");
            System.out.println("主线程执行完成...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
