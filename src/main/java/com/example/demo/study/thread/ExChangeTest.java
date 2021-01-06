package com.example.demo.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ExChangeTest {

    //交换两个线程的数据
    public static final Exchanger<List<String>> exChanger = new Exchanger();

    public static void main(String[] args) {
        new AtomicInteger();
        new ConcurrentHashMap<>();
        new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list = new ArrayList<>();
                list.add("101");
                list.add("102");
                try {
                    //当线程运行到这一步的时候，线程1就会拿到线程2中的list数据
                    List<String> exchange = exChanger.exchange(list);
                    for(String str:exchange){
                        System.out.println("我是线程1: "+str);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list = new ArrayList<>();
                list.add("201");
                list.add("202");
                try {
                    //当线程运行到这一步的时候，线程2就会拿到线程1中的list数据
                    List<String> exchange = exChanger.exchange(list);
                    for(String str:exchange){
                        System.out.println("我是线程2: "+str);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
