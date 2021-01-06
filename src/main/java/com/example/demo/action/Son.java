package com.example.demo.action;

import java.util.UUID;

public class Son extends Super {
    public static final int obj = 10;
    public static final String str = "常量";

    public static  final String uuid = UUID.randomUUID().toString();
    public static final Integer strs = new Integer(10);
    static {
        System.out.println("Son init");
    }
}
