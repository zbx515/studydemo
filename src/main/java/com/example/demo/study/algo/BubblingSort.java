package com.example.demo.study.algo;

/**
 * 冒泡排序
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] arr = {8,5,1,3,4,6,9,2,7};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int n : arr){
            System.out.print(n+" ");
        }
    }
}
