package com.example.demo.jgs.jvm;

public class B {

    private static int d = 10;

    /*static {
        int c = 10;
        System.out.println(c);
    }*/
    public static void main(String[] args) {
       /* B b = new B();*/
        int a = A.a;
        String aa = A.aa;
        System.out.println(a+aa);
    }
}
