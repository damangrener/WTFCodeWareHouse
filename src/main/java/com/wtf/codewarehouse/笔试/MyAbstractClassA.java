package com.wtf.codewarehouse.笔试;

abstract class MyAbstractClassA{
    public abstract void m1(); //1
//    abstract protected void m2(){} //2
}
class MyAbstrtactClaaB extends MyAbstractClassA{
//    void m1(){} //3
    public void m2(){} //4

    @Override
    public void m1() {

    }

    public static void main(String[] args) {
        short x = 1;
        short y = 2;
        x *= y ;
    }
}