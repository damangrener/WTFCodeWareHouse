package com.wtf.codewarehouse.javabase.thread.demo;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {

    private static Lock lock = new ReentrantLock();

    private static volatile boolean flag = true;
    private static int i = 0;
    private static int j = 65;

    public static void altermatePrint() {
        Thread t1 = new Thread(() -> {
            while (i < 10) {
                lock.lock();
                while (flag) {
                    System.out.println(++i);
                    flag = false;
                }
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            while (i < 10) {
                lock.lock();
                while (!flag) {
                    System.out.println((char) (j++));
                    flag = true;
                }
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        Demo1.altermatePrint();
    }
}
