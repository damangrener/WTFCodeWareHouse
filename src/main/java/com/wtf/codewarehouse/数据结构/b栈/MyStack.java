package com.wtf.codewarehouse.数据结构.b栈;

public class MyStack {

    int[] elements;

    public MyStack() {
        elements = new int[0];
    }

    public int size() {
        return elements.length;
    }

    //压入元素
    public void push(int element) {
        //创建一个新数组
        int[] newArr = new int[elements.length + 1];
        //把原数组的元素复制到新数组中
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        //把添加的元素放入最后一位
        newArr[elements.length] = element;
        elements = newArr;
    }

    //查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements[elements.length - 1];
    }

    //取出栈顶元素
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int element = elements[elements.length - 1];
        int[] newArr = new int[elements.length - 1];
        System.arraycopy(elements, 0, newArr, 0, newArr.length);
        elements = newArr;
        return element;
    }

    //查看栈是否为空
    public boolean isEmpty() {
        return elements.length == 0;
    }
}
