package com.example.demo.study.algo;

public class SelectionSort {
    //选择排序
    public static void main(String[] args) {
        int[] arr = {6,3,7,2,1,4,5};
        for(int i=0;i<arr.length-1;i++){
            //初始化最小值，默认为当前值
            int minPos = i;
            //初始化最大值
            int maxPos = arr.length-1-i;
            for(int j=i+1;j<arr.length-i;j++){
                //如果后边的值小于当前设定的最小值，就把该值所在的下标赋值给最小
                /*if(arr[j]<arr[minPos]){
                    minPos = j;
                }*/
                minPos = arr[j]<arr[minPos]? j :minPos;
                maxPos = arr[j]>arr[maxPos]? j :maxPos;
            }
            //交换最小值
            int minTemp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = minTemp;
            //交换最小值
            int maxTemp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[maxPos];
            arr[maxPos] = maxTemp;
        }
        for(int n:arr){
            System.out.print(n+" ");
        }
    }
}
