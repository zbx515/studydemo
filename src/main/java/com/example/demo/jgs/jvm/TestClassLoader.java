package com.example.demo.jgs.jvm;

import java.io.*;
import java.lang.reflect.Method;

public class TestClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception{
        TestClassLoader loader = new TestClassLoader();
        Class<?> defineClass = loader.findClass("");
        Object instance = defineClass.newInstance();
        Method method = defineClass.getMethod("m");
        method.invoke(instance);
        System.out.println("自定义类加载器..."+defineClass.getName());
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
