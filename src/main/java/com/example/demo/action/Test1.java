package com.example.demo.action;

public class Test1 {
    private int age=10;
    public static final String name="测试";
    static {
        System.out.println("Test1 init");
    }
    public Test1(){
        System.out.println("Test1 Curstor init"+"name:"+this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

   /* public void setName(String name) {
        this.name = name;
    }*/
}
