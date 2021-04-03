package com.wtf.codewarehouse.算法.稀疏数组.aaa递归;

public class Fibonacci {

    //斐波那契数列：1 1 2 3 5 8 13

    public static int fibonacci(int index){
        if(index==1||index==2){
            return 1;
        }else {
            return fibonacci(index-1)+fibonacci(index-2);
        }
    }

    public static void main(String[] args) {
        int i=fibonacci(6);
        System.out.println(i);
    }
}
