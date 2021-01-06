package com.example.demo.jgs.juc;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConSumerTest2 {
    public static void main(String[] args) {
        Mycontainer mycontainer = new Mycontainer();
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    mycontainer.put(Thread.currentThread().getName()+" "+j);
                }
            },"a"+i+": ").start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<2;i++){
            new Thread(()-> {
                for(int j=0;j<25;j++){
                    System.out.println(Thread.currentThread().getName()+" "+mycontainer.get());
                }
            },"p"+i+": ").start();
        }
    }

    static class Mycontainer<T>{
        LinkedList<T> linkedList = new LinkedList();
        public Lock lock =  new ReentrantLock();
        Condition consumer = lock.newCondition();
        Condition producer = lock.newCondition();

        int MAX = 10;
        int count = 0;
        void put(T t){
            try {
                lock.lock();
                while(linkedList.size() == MAX){
                    try {
                        producer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                linkedList.add(t);
                ++count;
                consumer.signalAll();
            }finally {
                lock.unlock();
            }

        }

        T get(){
            try{
                lock.lock();
                while(linkedList.size() == 0){
                    try {
                        consumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T t = linkedList.removeFirst();
                count--;
                producer.signalAll();
                return t;
            }finally {
                lock.unlock();
            }
        }
    }
}
