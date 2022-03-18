package com.example.demo.jgs.jvm;

import org.openjdk.jol.info.ClassLayout;

public class MyClassLyout {
    public static void main(String[] args) {
        MyClassLyout myClassLyout = new MyClassLyout();
        System.out.println(ClassLayout.parseClass(MyClassLyout.class).toPrintable());
        System.out.println("---");
        System.out.println(ClassLayout.parseInstance(myClassLyout).toPrintable());
    }
}
