package com.wtf.codewarehouse.数据结构.d链表.a单链表;

public class Node {

    //数据
    int data;
    //下一个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //为节点追加节点
    public Node append(Node node) {
        Node currentNode = this;
        while (true) {
            if (currentNode.next != null) {
                currentNode = this.next;
            } else {
                currentNode.next = node;
                break;
            }
        }
        return currentNode;
    }

    //删除节点
    public Node removeNode(int data) {
        Node currentNode = this;
        if (currentNode == null) {
            return null;
        }
        if (currentNode.data == data) {
            currentNode = this.next;
            return currentNode;
        }
        while (true) {
            if (data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
                return currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    //插入节点(当前节点之后)
    public void insertNode(Node node) {
        Node currentNode = this;
        node.next = this.next;
        currentNode.next = node;

    }

    //判断当前节点是不是最后一个
    public boolean isLast(Node node) {
        return node == null;
    }

    public int getData() {
        return this.data;
    }
}
