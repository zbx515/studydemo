package com.example.demo.juc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Test {
    private static Map map =new HashMap();
    public Test(){
        map.put("name","半仙");
    }
    public static void main(String[] args) {
        Map map = getMap();
        map.put("name","hahaha");
        System.out.println(map.hashCode());
        String name = (String)getMap().get("name");
        System.out.println(Test.map.hashCode());
        System.out.println(name);
        Logger.getGlobal().info("哈哈哈");

    }


    public static Map getMap(){
        return map;
    }
}
