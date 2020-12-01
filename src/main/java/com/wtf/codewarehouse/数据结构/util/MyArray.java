package com.wtf.codewarehouse.数据结构.util;

import java.util.Arrays;

public class MyArray {

    //用于存储数据的数组
    private int[] elements;

    public MyArray(){
        elements=new int[0];
    }

    public int size(){
        return elements.length;
    }

    //添加元素
    public void add(int element){
        int[] newArr=new int[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i]=elements[i];
        }
        newArr[elements.length]=element;
        elements=newArr;
    }

    //打印所有元素
    public void show(){
//        for (int i = 0; i < elements.length; i++) {
//            System.out.println(elements[i]);
//        }
        System.out.println(Arrays.toString(elements));
    }

    //刪除
    public void delete(int index){

        checkIndex(index);
        //01.创建一个新的数组，长度是原数组长度-1
        int[] newArr=new int[elements.length-1];
        //02.复制元素，除了删除的
        for (int i = 0; i < newArr.length; i++) {
            if(i<index){
                newArr[i]=elements[i];
            }else{
                //前移
                newArr[i]=elements[i+1];
            }
        }
        elements=newArr;

    }

    //获取某个元素
    public int get(int index){
        checkIndex(index);
        return elements[index];
    }

    //插入一个元素到指定位置
    public void insert(int index,int element){
        int newArr[]=new int[elements.length+1];

        for (int i = 0; i < elements.length; i++) {
            if(i<index){
                newArr[i]=elements[i];
            }else{
                newArr[i+1]=elements[i];
            }
        }

        newArr[index]=element;
        elements=newArr;
    }

    //替换指定位置元素
    public void set(int index,int element){
        checkIndex(index);
        elements[index]=element;
    }

    //线性查找元素位置
    public int getFirstIndex(int element){
        int index=-1;
        for (int i = 0; i < elements.length; i++) {
            if(element==elements[i]){
                index=i;
                break;
            }
        }
        return index;
    }


    private void checkIndex(int index){
        if(index<0||index>elements.length-1){
            throw new RuntimeException("indexOutOfBound");
        }
    }

    public static void main(String[] args) {
        MyArray arr=new MyArray();
//        System.out.println(arr.size());
        arr.add(99);
        arr.add(98);
        arr.add(97);
        arr.add(96);
//        System.out.println(arr.size());
        arr.show();
        arr.delete(0);
        arr.show();
        System.out.println(arr.get(2));
        arr.insert(2,3);
        arr.show();
        arr.set(0,111);
        arr.show();
        System.out.println(arr.getFirstIndex(1111));
    }

}
