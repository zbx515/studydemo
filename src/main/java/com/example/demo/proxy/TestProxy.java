package com.example.demo.proxy;

public class TestProxy {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal proxy = MyProxy.getProxy(dog);
        proxy.eat();
    }
}
