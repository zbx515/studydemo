package com.example.demo.spboot.utils;

import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;

public class RunTask implements Runnable{

    private String color;

    private RedissonClient redissonClient;
    public RunTask(){

    }
    public RunTask(RedissonClient redissonClient,String color){
        this.redissonClient = redissonClient;
        this.color = color;
    }

    @Override
    public void run() {
        RList<String> list = redissonClient.getList("wtyw");
        String remove = list.remove(0);
        if(remove != null){
            System.out.println(remove);
        }
    }
}
