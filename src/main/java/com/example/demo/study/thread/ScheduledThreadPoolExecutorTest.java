package com.example.demo.study.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        //执行定时任务的线程池
        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(3);
        poolExecutor.scheduleAtFixedRate(new Worker(),1,3, TimeUnit.SECONDS);
    }

    static class Worker implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }
}
