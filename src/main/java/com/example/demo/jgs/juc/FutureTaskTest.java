package com.example.demo.jgs.juc;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return "Hello Future";
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        //自定义线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
    }
}
