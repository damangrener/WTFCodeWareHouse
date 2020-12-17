package com.wtf.codewarehouse.数据结构.util;


public class Node {

    int data;
    //下一个节点
    Node next;

    public Node(int data){
        this.data=data;
    }

    public Node append(Node node){
        Node currentNode=this;
        while(true){
            Node nextNode=currentNode.next();
            if(null==nextNode){
                break;
            }
            currentNode=nextNode;
        }
        this.next=node;
        return this;
    }

    //获取下一个节点
    public Node next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

    public boolean isLast(){
        return this.next==null;
    }

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.append(n2);
        n1.append(n3).append(new Node(4));
        System.out.println(n1.next.getData());
        System.out.println(n2.next.getData());
        System.out.println(n1.isLast());
        System.out.println(n3.next().isLast());
    }
}
