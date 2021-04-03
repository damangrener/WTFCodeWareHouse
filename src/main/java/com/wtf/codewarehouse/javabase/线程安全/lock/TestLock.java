package com.wtf.codewarehouse.javabase.线程安全.lock;

import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    private Lock lock = new ReentrantLock();

    private void method(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程名：" + thread.getName() + "获得了锁");
        } finally {
            System.out.println("线程名：" + thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    @SneakyThrows
    private void tryMethod(Thread thread){
        if(lock.tryLock(5, TimeUnit.SECONDS)){
            try {
                System.out.println("线程名：" + thread.getName() + "获得了锁");
                Thread.sleep(3000);
            } finally {
                System.out.println("线程名：" + thread.getName() + "释放了锁");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestLock testLock=new TestLock();
        Thread t1=new Thread(() -> testLock.tryMethod(Thread.currentThread()));
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                testLock.tryMethod(Thread.currentThread());
            }
        });
        t1.start();

        t2.start();
        t1.join();
    }
}
