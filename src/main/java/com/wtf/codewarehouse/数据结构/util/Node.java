package com.wtf.codewarehouse.数据结构.util;


public class Node {

    int data;
    //下一个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node append(Node node) {
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.next();
            if (null == nextNode) {
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next=node;
        return this;
    }

    //获取下一个节点
    public Node next() {
        return this.next;
    }

    //删除下一个节点
    public void removeNext() {
        //取出下一个节点
        Node newNext = next.next;
        this.next = newNext;
    }

    //插入节点
    public void after(Node node){
        Node currentNode=this;
        Node nextNode=this.next;
        currentNode.next=node;
        currentNode.next.next=nextNode;
    }

    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
    }

    public int getData() {
        return this.data;
    }

    public boolean isLast() {
        return this.next == null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
//        n1.append(n2);
        n1.append(n2).append(n3).append(new Node(4));
//        System.out.println(n1.next.getData());
//        System.out.println(n2.next.getData());
//        System.out.println(n1.isLast());
//        System.out.println(n3.next().isLast());
        n1.show();
        n1.removeNext();
        System.out.println();
        n3.next().after(new Node(6));
        n1.show();
    }
}
