package com.example.demo.study.algo;

public class ShellSort {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    public static long sum(int n){
        if(n==1)
            return 1;
        return sum(n-1)*n;
    }
}
