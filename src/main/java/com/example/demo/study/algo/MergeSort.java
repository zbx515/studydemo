package com.example.demo.study.algo;

public class MergeSort {
    public static int[] result;

    public static void main(String[] args) {
        int[] arr = {1,4,6,9,10,11,2,3,5,8,7,};
        result = new int[arr.length];
        sort(arr,0, arr.length-1);
        for(int n:result){
            System.out.print(n+" ");
        }
    }

    public static void sort(int[] arr,int leftPrt,int rightPrt){
        if (arr.length == 0) return;
        if (rightPrt <= leftPrt)return;
        int midPrt = leftPrt + (rightPrt -leftPrt )/2;
        sort(arr,leftPrt,midPrt);
        sort(arr,midPrt+1,rightPrt);
        merge(arr,leftPrt,midPrt,rightPrt);
    }


    public static void merge(int[] arr,int leftPrt,int midPrt,int rightPrt){
        /*int leftPrt = 0;
        int midPrt = leftPrt+ (arr.length-1-leftPrt)/2;
        int rightPrt = arr.length-1;*/
        int[] temp = new int[arr.length];
        int i=leftPrt,j=midPrt+1;
        for(int k=leftPrt;k<=rightPrt;k++){
            if(j>rightPrt) temp[k] = arr[i++];
            else if(i>midPrt) temp[k] = arr[j++];
            else if(arr[i]<arr[j]){
                temp[k] = arr[i++];
            }else{
                temp[k] = arr[j++];
            }
        }
        for(int m=0;m<temp.length;m++){
            result[m] =temp[m];
        }
    }
}
