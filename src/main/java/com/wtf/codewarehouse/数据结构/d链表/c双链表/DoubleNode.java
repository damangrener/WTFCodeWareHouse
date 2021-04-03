package com.wtf.codewarehouse.数据结构.d链表.c双链表;

public class DoubleNode {

    //上一个节点
    DoubleNode pre=this;
    //下一个节点
    DoubleNode next=this;
    //数据
    int data;

    public DoubleNode(int data){
        this.data=data;
    }

    //增加节点
    public void after(DoubleNode node){
        node.pre=this;
        node.next=this.next;
        this.next=node;
        this.next.pre=node;
    }

    public DoubleNode getNext(){
        return this.getNext();
    }
    public DoubleNode getPre(){
        return this.getPre();
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "pre=" + pre.data +
                ", next=" + next.data +
                ", data=" + data +
                '}';
    }

    public static void main(String[] args) {
        DoubleNode n1=new DoubleNode(1);
        DoubleNode n2=new DoubleNode(2);
        DoubleNode n3=new DoubleNode(3);

        n1.after(n2);
        n2.after(n3);
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        System.out.println(n3.toString());
    }
}
