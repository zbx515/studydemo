package com.example.demo.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReadTest {
    public static void main(String[] args)throws Exception {
        System.out.println(2&0);
        ///u01/Middleware/user_projects/domains/base_domain/servers/AdminServer
        ///改此文件 u01/Middleware/user_projects/domains/base_domain/bin/startWebLogic.sh
        //SAVE_JAVA_OPTIONS="${JAVA_OPTIONS} -Dcom.sun.xml.ws.spi.db.BindingContextFactory=com.sun.xml.ws.db.glassfish.JAXBRIContextFactory -Djavax.xml.bind.JAXBContext=com.sun.xml.bind.v2.ContextFactory"

    }
}

class A{
    private int num = 6;
    public A(){
        show();
    }
    public void show(){
        System.out.println("A show");
    }
}
class B extends A{
    private int num = 8;
    {
        System.out.println("B s init "+num);
    }
    public B(){
        System.out.println("B init "+num);
    }
    public void show(){
        System.out.println("B show "+num);
    }
}
