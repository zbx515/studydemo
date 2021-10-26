package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {

    public static Animal getProxy(Animal animal){
        ClassLoader classLoader = animal.getClass().getClassLoader();
        Class<?>[] interfaces = animal.getClass().getInterfaces();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前...");
                method.invoke(animal, args);
                System.out.println("方法执行后...");
                return null;
            }
        });
        return (Animal)proxyInstance;
    }
}
