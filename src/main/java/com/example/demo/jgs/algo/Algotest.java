package com.example.demo.jgs.algo;

public class Algotest {
    public static void main(String[] args) {
        getNum();
    }

    /**
     * 找出一个数组中出现了奇数次的两个数
     * 不得不说，异或运算还能这样  是真他娘的秒呀
     */
    public static void getNum(){
        int[] arr = {6,6,6,10,12,12,4,4};
        int eor = 0;
        for (int i = 0; i <arr.length ; i++) {
            //跑完所有for循环后，得到的就是两个出现了奇数次的数的异或结果
            //即6^10
            eor ^= arr[i];
        }
        //提取出最右侧的1的位置
        //一个数与上自己的相反数，就会得到最右侧的1的位置
        int temp = eor&(-eor);
        int eor2 = 0;
        for (int i = 0; i <arr.length ; i++) {
            //找出最有侧1的位置和temp相同的数
            if((temp & arr[i]) != 0){
                //此时执行完异或操作后，就会得到其中一个出现了奇数次的数
                eor2 ^=arr[i];
            }
        }
        System.out.println(eor2);
        //将已经得到的一个出现了奇数次的数异或上最初的结果 ，就能得到另外一个出现了奇数次的数
        System.out.println(eor2^eor);

    }
}
