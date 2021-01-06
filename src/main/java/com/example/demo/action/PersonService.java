package com.example.demo.action;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class PersonService {

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destory(){
       System.out.println("destory");
    }
}
