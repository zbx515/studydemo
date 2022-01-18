package com.example.demo.jgs.juc;

import io.netty.util.concurrent.CompleteFuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplateFutureTest {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Integer a = CompletableFuture.supplyAsync(() -> backa()).join();
        Integer b = CompletableFuture.supplyAsync(() -> backb()).join();
        //CompletableFuture.allOf(a, b).join();
        System.out.println(a+b);
    }

    public static Integer backa(){
        return 3;
    }
    public static Integer backb(){
        return 6;
    }
}
