package com.wtf.codewarehouse.数据结构.MyArray;

import java.util.Arrays;

public class A2TestDeleteArray {

    //删除数组中的元素
    public static void main(String[] args) {

        //目标数组
        int[] arr=new int[]{9,8,7,6,5,4};
        //要刪除元素的下标
        int delIndex=3;

        //01.创建一个新的数组，长度是原数组长度-1
        int[] newArr=new int[arr.length-1];
        //02.复制元素，除了删除的
        for (int i = 0; i < newArr.length; i++) {
            if(i<delIndex){
                newArr[i]=arr[i];
            }else{
                //前移
                newArr[i]=arr[i+1];
            }
        }
        arr=newArr;
        System.out.println(Arrays.toString(arr));
    }
}
