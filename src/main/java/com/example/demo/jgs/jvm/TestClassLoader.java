package com.example.demo.jgs.jvm;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception{
        ArrayList<Object> objects = new ArrayList<>();
        TestClassLoader loader = new TestClassLoader();
        for (int i = 0; i < 2; i++) {
            System.out.println("classloader -------------");
            System.out.println(loader);
            Class<?> defineClass = loader.findClass("");
            objects.add(defineClass);
            System.out.println("defineClass -------------");
            System.out.println(defineClass);
            Object instance = defineClass.newInstance();
            /*Method method = defineClass.getMethod("m");
            method.invoke(instance);*/
            System.out.println("自定义类加载器..."+instance);
        }
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
            System.out.println(objects.get(0)==objects.get(1));
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //File file = new File("",name.replaceAll(".","/"));
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("F:\\ideaWork\\demo\\demo\\webapp\\WEB-INF\\classes\\test\\Hello.class");
            outputStream = new ByteArrayOutputStream();
            int len = 0;
            while((len = inputStream.read()) != -1){
                outputStream.write(len);
            }
            byte[] bytes = outputStream.toByteArray();

            Class<?> defineClass = defineClass(bytes, 0, bytes.length);
            
            return defineClass;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
