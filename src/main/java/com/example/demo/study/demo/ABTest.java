package com.example.demo.study.demo;

public abstract class ABTest {
    private static String name="abc";
    public abstract void print();

    static {
        System.out.println("static...");
    }

    public ABTest(){
        System.out.println("I am superClass");
    }

    public static void main(String[] args)throws Exception {
        Class<?> forName = Class.forName("com.example.demo.study.demo.ABTest");
        //Object o = forName.newInstance();

        //SunTest sunTest = new SunTest();
        //System.out.println(sunTest);

    }

    static class SunTest extends ABTest{

        public SunTest(){
            System.out.println("I am sunClass");
        }

        @Override
        public void print() {
            System.out.println("I am print");
        }
    }
}

