package com.example.demo.jgs.juc;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class ConSumerTest {

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

     static  class Mycontainer<T>{
        LinkedList<T> linkedList = new LinkedList();
        int MAX = 10;
        int count = 0;
        synchronized void put(T t){
            while(linkedList.size() == MAX){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            linkedList.add(t);
            ++count;
            this.notifyAll();
        }

        synchronized T get(){
            while(linkedList.size() == 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = linkedList.removeFirst();
            count--;
            this.notifyAll();
            return t;
        }
    }
}
