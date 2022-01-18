package com.example.demo.spboot.utils;

import com.example.demo.study.thread.ScheduledThreadPoolExecutorTest;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class MyInitializingBean implements InitializingBean, DisposableBean {

    @Value("${info.color}")
    private String color;

    @Autowired
    private RedissonClient redissonClient;

    private ScheduledThreadPoolExecutor poolExecutor;

    @Override
    public void afterPropertiesSet() throws Exception {
        poolExecutor = new ScheduledThreadPoolExecutor(2);
        poolExecutor.scheduleWithFixedDelay(new RunTask(redissonClient,color),10,1, TimeUnit.SECONDS);
    }

    @Override
    public void destroy() throws Exception {
        if(poolExecutor != null){
            System.out.println("定时任务销毁...");
            poolExecutor.shutdown();
        }
    }
}
