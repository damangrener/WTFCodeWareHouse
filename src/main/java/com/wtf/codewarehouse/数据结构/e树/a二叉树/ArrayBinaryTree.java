package com.wtf.codewarehouse.数据结构.e树.a二叉树;

public class ArrayBinaryTree {

    int[] data;

    public ArrayBinaryTree(int[] data){
        this.data=data;
    }

    public void frontShow(int index){
        if(data==null||data.length==0){
            return;
        }
        //根节点
        System.out.println(data[index]);
        //左二子
        if(2*index+1< data.length){
            frontShow(2*index+1);
        }
        //右儿子
        if(2*index+2< data.length){
            frontShow(2*index+2);
        }
    }

    public static void main(String[] args) {
        int[] data=new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree=new ArrayBinaryTree(data);
        arrayBinaryTree.frontShow(0);
    }

}
