package com.example.demo.test;

public class StringTest {
    public static void main(String[] args) {
        String a = "aa";
        System.out.println(a.intern() == a);//true

        String b = new String("bb");
        System.out.println(b.intern() == b);//false

        String s = new StringBuilder("123").append("2").toString();
        //String c = "1232";
        System.out.println(s.intern() == s);


        /*
        * 三个线程A，B,C，输入数字N代表了打印次数，
        * 比如：输入N=1，A:1 A:2 A:3 A:4 A:5(五个数为一组)，
        * B:6 B:7 B:8 B:9 B:10,
        * C:11 C:12 C:13 C:14 C:15
        * */

        /**
         * 字符串字面量 在编译解析常量池期间，就会放入stringTable中
         * 所以像 String a = "aa";  在编译期间虚拟机创建“aa”对象，把对象赋给 a
         * a.intern() 返回的就是这个“aa”字面量的地址
         * 这种 String b = new String("bb");
         * 是创建了一个新的string对象然后把 “bb”的字面量地址传给这个string
         * 所以 b.intern() 其实就是“bb”这个字面量的地址 所以和对象 b 不相等
         */
    }
}
