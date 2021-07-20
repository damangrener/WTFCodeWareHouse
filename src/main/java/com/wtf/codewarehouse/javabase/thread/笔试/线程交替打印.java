package com.wtf.codewarehouse.javabase.thread.笔试;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class 线程交替打印 {
    /**
     * 1A2B3C
     */
    @SneakyThrows
    public static void doubleThreadsPrint() {
        AtomicBoolean flag = new AtomicBoolean(true);
        AtomicInteger i = new AtomicInteger(1);
        AtomicInteger j = new AtomicInteger(65);
        Thread t1 = new Thread(() -> {
            while (i.get() < 10) {
                if (flag.get()) {
                    System.out.println(i.getAndAdd(1));
                    flag.set(false);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (i.get() < 10) {
                if (!flag.get()) {
                    System.out.println(j.getAndAdd(1));
                    flag.set(true);
                }
            }
        });
        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
        doubleThreadsPrint();
    }
}
