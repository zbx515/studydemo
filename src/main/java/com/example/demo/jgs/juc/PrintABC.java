package com.example.demo.jgs.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition printA = lock.newCondition();
        Condition printB = lock.newCondition();
        Condition printC = lock.newCondition();

        new Thread(()->{
            lock.lock();
            try {
                printC.await();
                System.out.print("- c \n");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            lock.lock();
            try {
                printB.await();
                System.out.print("- b");
                printC.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();


        new Thread(()->{
            lock.lock();
            try {
                System.out.print("a");
                printB.signal();
                printA.await();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }

        }).start();




    }


}
