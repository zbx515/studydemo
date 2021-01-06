package com.example.demo.action;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    //String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    //System.out.println("加载的类名..."+fileName);
                    InputStream in = getClass().getResourceAsStream(name);
                    if(in==null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

    public static void main(String[] args)throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        //context.addBeanFactoryPostProcessor(new MyBeanPostProcess());
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("mysql.info.color");
        System.out.println(property);

        /*String[] names = context.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
        context.close();*/
        PersonService bean = context.getBean(PersonService.class);
        //Object bean1 = context.getBean("personService");

        //System.out.println(bean);
        //System.out.println(bean1);

        //context.close();

        //ReentrantLock lock = new ReentrantLock();


        /*Test t = new Test();
        Class obj =  t.classLoader.loadClass("com.example.demo.controller.Test1");
        obj.newInstance();*/
       /* Method[] methods = obj.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        Field[] fields =  obj.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
        }*/
       // System.out.println(((Class) obj).getClasses());
       //Class clazz = Class.forName("com.example.demo.controller.Test1");
       /*  System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClassLoader().getParent());
        System.out.println(clazz.getClassLoader().getParent().getParent());*/
    }
}
