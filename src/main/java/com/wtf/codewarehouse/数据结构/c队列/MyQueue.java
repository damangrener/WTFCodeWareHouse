package com.wtf.codewarehouse.数据结构.c队列;

public class MyQueue {
    int[] elements;

    public MyQueue(){
        elements=new int[0];
    }

    //入队
    public void add(int element){
        //创建一个新数组
        int[] newArr=new int[elements.length+1];
        //把原数组的元素复制到新数组中
        for (int i = 0; i < elements.length; i++) {
            newArr[i]=elements[i];
        }
        //把添加的元素放入最后一位
        newArr[elements.length]=element;
        elements=newArr;
    }

    //出队
    public int poll(){
        int element=elements[0];
        int[] newArr=new int[elements.length-1];
        System.arraycopy(elements, 1, newArr, 0, newArr.length);

        elements=newArr;
        return element;
    }
}
