package com.example.demo.action;

public class Sigotion1 implements Runnable{

    private   Integer i=0;
    private Sigotion1(){}
    private static Sigotion1 sigotion1 = new Sigotion1();

    public static Sigotion1 getIntence(){
        return sigotion1;
    }

    public void print(int i)throws Exception{
            Thread.sleep(500);
            //++i;
            System.out.println(Thread.currentThread().getName()+"..."+ (i)+"   ");

    }
    //psvm
    @Override
    public  void run() {

            try {
                while(i<50){
                    synchronized (this){
                        i++;
                        print(i);
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public static void main(String[] args)throws Exception{
        Integer i = 0;
        Sigotion1 sigotion1 = Sigotion1.getIntence();
        Sigotion1 sigotion = Sigotion1.getIntence();
        System.out.println(sigotion1==sigotion);
        new Thread(sigotion1).start();
        new Thread(sigotion).start();
    }



}

