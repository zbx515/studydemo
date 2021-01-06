package com.example.demo.study.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //虚拟机线程管理的接口
        /*ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for(ThreadInfo thread:threadInfos){
            System.out.println(thread.getThreadName());
        }*/
        new Thread(new Thread1()).start();
        System.out.println("---------------------------------------------");
        new Thread(new Runnable1()).start();
        System.out.println("---------------------------------------------");
        //执行Callable类时，需要使用FutureTask来进行包装
        FutureTask<String> futureTask = new FutureTask<String>(new Callable1());
        new Thread(futureTask).start();
        //获取callable的返回值
        System.out.println(futureTask.get());


    }

    //实现一个线程的三种方式：Thread类、Runnable接口、Callable()接口
    //继承Thread类
    static class Thread1 extends Thread{
        public void run(){
            System.out.println("我是Thread类...");
        }
    }
    //实现Runnablej接口
    static class Runnable1 implements Runnable{
        @Override
        public void run() {
            System.out.println("我是runnable...");
        }
    }
    //实现callable接口,有返回值
    static class Callable1 implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("我是callable...");
            return "我是callable返回值..";
        }
    }
}
