package com.example.demo.action;

import javax.xml.soap.SOAPPart;

public class Singleton {
    public static volatile Singleton istance =null;

    private Singleton(){};
    //单例模式，双层检验
    public static Singleton getInstance(){
        if(null == istance){
            synchronized (Singleton.class){
                if(null == istance){
                    istance = new Singleton();
                }
            }
        }
        return Singleton.istance;
    }

    //比较友好，且优雅的单例
    private static  class SingletoHolder{
        private static final Singleton istance =new Singleton();
    }
    public static Singleton get(){
        return SingletoHolder.istance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.get();
        Singleton s4 = Singleton.get();
        System.out.println(s3==s4);
    }
}
