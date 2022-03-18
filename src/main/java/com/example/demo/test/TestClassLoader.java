package com.example.demo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i%3 == 0){
                arrayList.add("长的字符串"+i);
            }else{
                arrayList.add(i+"");
            }
        }
        arrayList.stream().sorted(Comparator.comparingInt(String::length)).filter(str-> str.length()>0).forEach(System.out::println);
    }
}
