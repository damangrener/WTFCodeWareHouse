package com.wtf.codewarehouse.数据结构.d链表.b循环链表;


public class LoopNode {

    int data;
    //下一个节点
    LoopNode next=this;

    public LoopNode(int data) {
        this.data = data;
    }


    //获取下一个节点
    public LoopNode next() {
        return this.next;
    }

    //删除下一个节点
    public void removeNext() {
        //取出下一个节点
        LoopNode newNext = next.next;
        this.next = newNext;
    }

    //插入节点
    public void after(LoopNode node){
        LoopNode currentNode=this;
        LoopNode nextNode=this.next;
        currentNode.next=node;
        currentNode.next.next=nextNode;
    }

    public void show() {
        LoopNode currentNode = this;
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
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);
        n1.after(n2);
        n2.after(n3);
        n3.after(n4);
        System.out.println(n1.next.getData());
        System.out.println(n2.next.getData());
        System.out.println(n3.next.getData());
        System.out.println(n4.next.getData());
    }
}
