package com.wtf.codewarehouse.数据结构.MyArray;

import java.util.Arrays;

public class A1TestAddArray {

    public static void main(String[] args) {
        /**
         * 解决数组的长读不可变的问题
         */
        int[] arr=new int[]{9,8,7};
        //查看数组中的元素
        System.out.println(Arrays.toString(arr));

        //插入数组的元素
        int addElement=6;

        //01.创建一个新的数组，长度是原数组长度+1
        int[] newArr=new int[arr.length+1];
        //02.把原数组的数据全部复制到新数组中
        for (int i = 0; i <arr.length ; i++) {
            newArr[i]=arr[i];
        }
        System.out.println(Arrays.toString(newArr));
        //03.把目标元素放入新数组的最后
        newArr[newArr.length-1]=addElement;
        System.out.println(Arrays.toString(newArr));
        //04.新数组替换原数组
        arr=newArr;
        System.out.println(Arrays.toString(arr));

    }
}
