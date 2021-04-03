package com.wtf.codewarehouse.javabase.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executorService= Executors.newFixedThreadPool(5);
//        for (int i = 0; i <10 ; i++) {
//            executorService.submit(()->{
//                System.out.println("thread id is: "+Thread.currentThread().getId());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    Integer.MAX_VALUE
//                }
//            });
//        }
//        int i=0;
//        System.out.println("i="+i);
        //创建有界阻塞任务队列
        BlockingQueue taskQueue=new LinkedBlockingQueue(10);
        //创建有3个工作线程的线程池
        ThreadPool pool=new ThreadPool(3,taskQueue);

        for (int i = 0; i <=10; i++) {
            final int j=i;
            pool.execute(()->{
                System.out.println("Thread:"+Thread.currentThread().getName()+",执行任务"+j);
            });
        }
    }
}
