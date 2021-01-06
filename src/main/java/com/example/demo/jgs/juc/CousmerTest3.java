package com.example.demo.jgs.juc;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class CousmerTest3 {
    private static final int MAX=20;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Object lock = new Object();
        CousmerTest3 cousmerTest3 = new CousmerTest3();
        Cousmer cousmer = cousmerTest3.new Cousmer(list,lock);
        Producer producer = cousmerTest3.new Producer(list,lock);
        Producer producer2 = cousmerTest3.new Producer(list,lock);
        Producer producer3 = cousmerTest3.new Producer(list,lock);
        Thread t1 = new Thread(cousmer,"cousmer");
        Thread t2 = new Thread(producer,"消费者1");
        Thread t3 = new Thread(producer2,"消费者2");
        Thread t4 = new Thread(producer3,"消费者3");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    class Cousmer implements Runnable{
        private LinkedList list;
        Object lock;
        public Cousmer(LinkedList list,Object lock){
            this.list = list;
            this.lock = lock;
        }
        @Override
        public void run() {
            while(true){
                synchronized (lock){
                    while(list.size() == MAX){
                        try {
                            System.out.println("生产完成，通知用户购买");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i=0;
                    while(i<5 && list.size()<MAX){
                        list.add("生产了一个");
                        i++;
                    }
                    lock.notifyAll();
                    System.out.println("用户可购买: "+list.size());
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Producer implements Runnable{
        private LinkedList list;
        Object lock;
        public Producer(LinkedList list,Object lock){
            this.lock = lock;
            this.list = list;
        }
        @Override
        public void run() {
            while(true){
                synchronized (lock){
                    while(list.size() == 0){
                        try {
                            System.out.println(Thread.currentThread().getName()+"没有商品了，通知生产。。。");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object o = list.removeFirst();
                    System.out.println(Thread.currentThread().getName()+"消费了一个,还剩余"+list.size()+"个");
                    lock.notifyAll();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
