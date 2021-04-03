package com.wtf.codewarehouse.数据结构.d链表.a单链表;

public class TestNode {
    public static void main(String[] args) {
        Node node1 =new Node(1);
        Node node2 =new Node(2);
        Node node3 =new Node(3);

        node1.append(node2).append(node3).getData();
        System.out.println(node1.next.getData());
        node1.insertNode(node3);
        System.out.println(node1.next.getData());
    }
}
