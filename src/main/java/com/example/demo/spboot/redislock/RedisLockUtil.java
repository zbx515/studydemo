package com.example.demo.spboot.redislock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Component
public class RedisLockUtil {

    @Autowired
    private RedissonClient redissonClient;

    public void getLock(int count){
        RLock lock = redissonClient.getLock("lock");
        //加锁
        lock.lock(10,TimeUnit.SECONDS);
        if(count > 0){
            count--;
            System.out.println(Thread.currentThread().getName()+"抢到了");
        }else{
            System.out.println(Thread.currentThread().getName()+"卖完了");
        }
        //解锁
        lock.unlock();
    }
}
