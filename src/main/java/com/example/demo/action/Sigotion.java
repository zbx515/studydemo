package com.example.demo.action;

public class Sigotion {

    private  int i=0;
    private Sigotion(){}
    private static Sigotion sigotion = new Sigotion();

    public static Sigotion getIntence(){
        return sigotion;
    }

    public void print(int i)throws Exception{
        while(true){
            Thread.sleep(50);
            ++i;
            System.out.println(Thread.currentThread().getName()+"..."+ (i)+"   ");
        }
    }
    public static void main(String[] args)throws Exception{
        Integer i = 0;
        Sigotion sigotion = Sigotion.getIntence();
        new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    sigotion.print(sigotion.i);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"t1").start();
        //Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    sigotion.print(sigotion.i);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }


}
