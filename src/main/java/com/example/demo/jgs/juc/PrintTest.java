package com.example.demo.jgs.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替输出
 */
public class PrintTest {
    static int[] ins = {1,2,3,};
    static char[] chars = {'a','b','c'};
    static  Thread t1,t2 = null;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            print1(t2);
        });
        t2 = new Thread(() -> {
            print2(t1);
        });
        t1.start();
        t2.start();
    }

    public static void print1(Thread thread){
        for(int i=0;i<ins.length;i++){
            System.out.println(ins[i]);
            LockSupport.unpark(thread);
            LockSupport.park();
        }
    }
    public static void print2(Thread thread){
        for(int i=0;i<chars.length;i++){
            LockSupport.park();
            System.out.println(chars[i]);
            LockSupport.unpark(thread);
        }
    }

}
