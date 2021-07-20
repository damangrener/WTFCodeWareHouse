package com.wtf.codewarehouse.javabase.thread.demo;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1Copy {

    /**
     * 两个线程循环打印
     * 1A2B...
     */
    private static Lock lock = new ReentrantLock();
    private static boolean flag = true;
    private volatile static int i = 1;
    private volatile static int j = 65;

    public static void alternatePrint() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 10) {
                    if (flag) {
//                        lock.lock();
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = false;
//                        lock.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (j < 75) {
                if (!flag) {
//                    lock.lock();
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (char) (j++));
                    flag = true;
//                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }


    @SneakyThrows
    public static void test(){
        AtomicInteger a=new AtomicInteger(1);
        AtomicInteger b=new AtomicInteger(65);
        Thread t1 = new Thread(() -> {
            while (a.get() < 10) {
                if (flag) {
                    System.out.println(a.getAndAdd(1));
                    flag = false;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (a.get() < 10) {
                if (!flag) {
                    System.out.println((char) (b.getAndAdd(1)));
                    flag = true;
                }
            }
        });
        t1.start();
        t2.start();
        t2.join();
        System.out.println(a.get());
        a.compareAndSet(a.get(),a.getAndAdd(2));
        System.out.println(a.get());

    }

    public static void main(String[] args) throws InterruptedException {
//        alternatePrint();
        test();
    }

}
