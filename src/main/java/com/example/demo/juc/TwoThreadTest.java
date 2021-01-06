package com.example.demo.juc;

public class TwoThreadTest {
    private static volatile boolean flag= true;
    private static int[] arr = {1,2,3,4,5,6};
    private static char[] chs = {'a','b','c','d','e','f'};


    public static void main(String[] args) {
        TwoThreadTest threadTest = new TwoThreadTest();
        Thread t1 = new Thread(threadTest::print);
        Thread t2 = new Thread(threadTest::print2);
        t1.start();
        t2.start();
    }



    public void print(){
        int i=0;
        while(i<arr.length){
            synchronized (this){
                if(!flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(arr[i++]);
                this.notify();
                flag=false;
            }
        }
    }
    public void print2(){
        int i=0;
        while(i<chs.length){
            synchronized (this){
                if(flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(chs[i++]);
                this.notify();
                flag=true;
            }
        }
    }
}
