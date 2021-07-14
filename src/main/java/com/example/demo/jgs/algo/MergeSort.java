package com.example.demo.jgs.algo;

import org.aspectj.weaver.ArrayReferenceType;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i <10 ; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        int[] sort = sort(arr);
        for (int i = 0; i <sort.length ; i++) {
            System.out.print(sort[i]+" ");
        }
    }

    public static int[] sort(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        int midle = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,midle);
        int[] right = Arrays.copyOfRange(arr,midle,arr.length);

        return merge1(sort(left),sort(right));
    }

    public static  int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int i=0;
        while(left.length>0 && right.length>0){
            if(left[0] > right[0]){
                result[i++] = right[0];
                right = Arrays.copyOfRange(right,1, right.length);
            }else{
                result[i++] = left[0];
                left = Arrays.copyOfRange(left,1, left.length);
            }
        }
        while(left.length > 0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left,1, left.length);
        }
        while(right.length > 0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right,1, right.length);
        }
        return result;
    }



    public static  int[] merge1(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int i=0 , l=0, r=0;
        while(left.length>l && right.length>r){
            if(left[l] > right[r]){
                result[i++] = right[r++];
            }else{
                result[i++] = left[l++];
            }
        }
        while(left.length > l){
            result[i++] = left[l++];
        }
        while(right.length > r){
            result[i++] = right[r++];
        }
        return result;
    }
}
