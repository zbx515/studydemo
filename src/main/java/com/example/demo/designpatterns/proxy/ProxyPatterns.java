package com.example.demo.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProxyPatterns {
    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        Dog dog = new Dog();
        /*Animal o = (Animal)Proxy.newProxyInstance(dog.getClass().getClassLoader(),
                dog.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理开始");
                        Object invoke = method.invoke(dog, args);
                        System.out.println("动态代理结束");
                        return invoke;
                    }
                });*/
        Animal o = (Animal)Proxy.newProxyInstance(dog.getClass().getClassLoader(),
                dog.getClass().getInterfaces(),
                new DogProxy(dog));
        o.talk();
    }
}

interface  Animal{
    void talk();
}

class Dog implements Animal{
    @Override
    public void talk() {
        System.out.println("小狗：汪 汪 汪");
    }
}

class DogProxy implements InvocationHandler{
    Dog dog;
    public DogProxy(Dog dog){
        this.dog =dog;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始");
        Object invoke = method.invoke(dog, args);
        System.out.println("动态代理结束");
        return invoke;
    }
}

