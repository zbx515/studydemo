package com.example.demo.jgs.juc;

import io.netty.util.concurrent.CompleteFuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplateFutureTest {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(()->backa());
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(()->backb());
        CompletableFuture.allOf(a,b).join();
        System.in.read();
    }

    public static Integer backa(){
        return 3;
    }
    public static Integer backb(){
        return 6;
    }
}
