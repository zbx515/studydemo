package com.example.demo.study.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        //执行定时任务的线程池
        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(3);
        poolExecutor.scheduleAtFixedRate(new Worker(),0,2, TimeUnit.SECONDS);
        //poolExecutor.scheduleWithFixedDelay(new Worker(),1,3, TimeUnit.SECONDS);
    }

    static class Worker implements Runnable{
        static AtomicInteger count = new AtomicInteger();
        @Override
        public void run() {
            try {
                int andIncrement = count.getAndIncrement();
                System.out.println(andIncrement+" 睡之前的： "+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println(andIncrement+"睡醒之后的");
            }catch (Exception e){
            }
        }
    }
}
