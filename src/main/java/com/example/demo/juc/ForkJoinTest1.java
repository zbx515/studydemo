package com.example.demo.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinTest1 {
    //定义每个线程可处理的最大任务量
    private final static int MAX_HANDLE = 200;

    /**
     *  ForkJoin  采用分治思想，有返回值的线程接口，将一个任务拆分成多个子任务交给不同的线程去执行，
     *  每个子线程返回执行的结果，最后进行汇总
     *  example:计算0-1000的累加，规定每个子线程最多执行200个数的相加，就需要把任务分给多个子线程
     *  去执行，将最后的结果汇总即可，这里的多个子线程会并发去执行，可以提高效率
     */

    public static void main(String[] args) {
        //ForkJoi的任务都需要提交给ForkJoinPool去执行
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //将自己实现的ForkTask提交给ForkJoinPool去执行
        ForkJoinTask<Integer> joinTask = forkJoinPool.submit(new InFork(0, 1000));
        try {
            //这一步会阻塞获取执行的结果，其中原理参考Future
            Integer integer = joinTask.get();
            //打印结果
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    //自定义实现了ForkJoinTask的类，需要实现其中的compute方法
    static class InFork extends RecursiveTask<Integer> {
        private final int start;
        private final int end;

        public InFork(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start > MAX_HANDLE) {
                int moddile = (end + start) / 2;
                //分而治之，将任务分给多个线程去执行
                InFork leftFork = new InFork(start, moddile);
                InFork rightFork = new InFork(moddile + 1, end);
                //调用fork方法执行任务
                leftFork.fork();
                rightFork.fork();
                //调用join方法获取执行结果
                return leftFork.join() + rightFork.join();
            } else {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
                //return  IntStream.rangeClosed(start,end).sum();
            }
        }
    }
}
