package com.wtf.codewarehouse.算法.稀疏数组.aaa递归;

public class TestRecursion {

    public static void print(int i){
        if(i>0){
            System.out.println(i);
            print(i-1);
        }
    }

    public static void main(String[] args) {
        print(10);
    }
}
