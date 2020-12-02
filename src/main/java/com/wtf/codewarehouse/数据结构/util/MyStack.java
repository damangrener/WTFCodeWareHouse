package com.wtf.codewarehouse.数据结构.util;

import java.util.Stack;

public class MyStack {

    int[] elements;

    public MyStack(){
        elements=new int[0];
    }

    public int size(){
        return elements.length;
    }

    //压入元素
    public void push(int element){
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

    //取出栈顶元素
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        //取出数组的最后一个元素
        int element=elements[elements.length-1];
        //创建一个新数组
        int[] newArr=new int[elements.length-1];
        for (int i = 0; i <newArr.length ; i++) {
            newArr[i]=elements[i];
        }
        elements=newArr;
        return element;
    }

    //查看栈顶元素
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int element=elements[elements.length-1];
        return element;
    }

    public boolean isEmpty(){
        return elements.length==0;
    }

    public static void main(String[] args) {
        MyStack stack=new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(9);
        System.out.println(stack.isEmpty());
        stack.push(99);
        stack.push(999);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

}
