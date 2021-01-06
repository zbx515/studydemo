package com.example.demo.study;

public class Test {
    public static void main(String[] args) {
        String s = "dnkandagdkbkdfbakhdmabdj";
        String t = "bakh";
        int search = Test.search(s, t);
        System.out.println(search);
    }
    public static int search(String s,String t){
        //目标文本的长度
        int M = s.length();
        //模式文本的长度
        int N = t.length();
        //对目标文本从第一个开始遍历，遍历长度为目标文本-模式文本(s-t)
        for(int i=0;i<=M-N;i++){
            int j;
            //目标文本每后移一位，模式文本从头开始匹配
            for(j=0;j<N;j++){
                //判断此轮中s的字符是否等于t中的字符，不相等、则退出内存循环，目标文本后移一位
                if(s.charAt(i+j)!=t.charAt(j)){
                    break;
                }
            }
            //当j==N,即相匹配，此时返回i，即模式文本在目标文本中的起始位置
            if(j==N){
                return i;
            }
        }
        return 0;
    }
}
