package com.example.demo.jgs.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        for(int i=0;i<18;i++){
            new Thread(()->read(readLock)).start();
        }
        for(int i=0;i<2;i++){
            new Thread(()->write(writeLock)).start();
        }
    }
    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(TimeUnit.SECONDS.toSeconds(1000));
            System.out.println("read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock){
        try {
            lock.lock();
            Thread.sleep(TimeUnit.SECONDS.toSeconds(1000));
            System.out.println("write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
