package com.example.demo.spboot.controller;

import com.example.demo.spboot.redislock.RedisLockUtil;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

@Controller
public class RedisController {



    @Autowired
    private RedissonClient redissonClient;

    private int count = 1;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(100);

    @RequestMapping("set")
    @ResponseBody
    public String setRedis(){
        RList<String> wtyw = redissonClient.getList("wtyw");
        for (int i = 0; i < 100; i++) {
            wtyw.add("我是第 "+i+"个");
        }
        return "ok";
    }

    @RequestMapping("redis")
    @ResponseBody
    public String redis(){
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                    RLock lock = redissonClient.getLock("lock");
                    //加锁
                    lock.lock(10, TimeUnit.SECONDS);
                    if(count > 0){
                        count--;
                        System.out.println(Thread.currentThread().getName()+"抢到了");
                    }else{
                        System.out.println(Thread.currentThread().getName()+"卖完了");
                    }
                    //解锁
                    lock.unlock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
        return "hahaha";
    }
}
