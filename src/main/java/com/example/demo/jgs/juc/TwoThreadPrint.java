package com.example.demo.jgs.juc;

public class TwoThreadPrint {
    static int[] ints = {1,2,3,4,};
    static char[] chars = {'a','b','c','d'};

    public static void main(String[] args) {
        TwoThreadPrint threadPrint = new TwoThreadPrint();
        new Thread(threadPrint::printInt).start();
        new Thread(threadPrint::printChar).start();
    }

    public void printInt(){
        synchronized (this){
            for(int i=0;i<ints.length;i++){
                System.out.println(ints[i]);
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();
        }
    }
    public void printChar(){
        synchronized (this){
            for(int i=0;i<chars.length;i++){
                System.out.println(chars[i]);
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();
        }
    }
}
