package com.example.demo.action;

public class SuperTest {
    public static void main(String[] args) {
        //System.out.println(Son.value);  -XX:+TraceClassLoading
        //Super[] arrs = new Super[10];
        //System.out.println(Son.value);
        //System.out.println(Son.str);
        //System.out.println(Son.strs);
        System.out.println(Son.uuid);
        Simple simple = Simple.getSimple();
        System.out.println(Simple.const1);
        System.out.println(Simple.const2);


    }
}
class Simple{
    public static int const1;


    private static Simple simple = new Simple();
    public Simple(){
        const1++;
        const2++;
    }
    public static int const2=0;
    public static Simple getSimple(){
        return simple;
    }
}
