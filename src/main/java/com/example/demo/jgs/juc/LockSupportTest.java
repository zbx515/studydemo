package com.example.demo.jgs.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for(int i=0;i<10;i++){
                if(i == 5){
                    LockSupport.park();
                }
                System.out.println(i);
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("8 senconds over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }
}
