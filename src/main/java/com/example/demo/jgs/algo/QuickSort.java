package com.example.demo.jgs.algo;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int)(Math.random()*300);
        }
        sort(arr,0,arr.length-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int[] sort(int[] arr,int l,int r){
        if(l < r){
            int provit = getprovit(arr,l,r);
            sort(arr,l,provit-1);
            sort(arr,provit+1,r);
        }
        return null;
    }

    public static int getprovit(int[] arr,int l,int r){
        int provit = arr[l];
        while(r != l && l<r){
            while(l<r && arr[r]>provit){
                r--;
            }
            if(l < r){
                arr[l++] =  arr[r];
            }
            while(l<r && arr[l] < provit){
                l++;
            }
            if(l < r){
                arr[r--] = arr[l];
            }
        }
        arr[l] = provit;
        return l;
        //微信 18691028136/ 电话 18191149663
    }
}
