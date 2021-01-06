package com.example.demo.juc;

import java.util.concurrent.*;

/**
 *  Future:把一些需要耗时的任务，异步去执行，未来在需要用到该任务执行结果的时候，再去获取该任务的结果
 *  这样就不用一直在阻塞等待该任务执行返回结果，可以同时执行下一步得操作
 *  example:去蛋糕店定了一定个蛋糕，店家告诉你做蛋糕需要好几个小时、然后店家给你了一个号码，告诉你以后可以用这个来取蛋糕
 *          在店家做蛋糕的这几个小时里，你可以在蛋糕店坐着等你的蛋糕，也可以去做其他事情，几个小时之后，去拿你的蛋糕就可以
 */

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ///模拟异步执行任务
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return 10;
            }
        });
        //在执行任务时可以做一些其他的事情，
        System.out.println("我想搞点事情...");
        System.out.println(future.isDone());
        //这一步是阻塞的，等待异步执行任务的返回结果
        Integer integer = future.get();
        System.out.println(integer);
        System.out.println(future.isDone());
        //executorService.shutdown();
    }
}
