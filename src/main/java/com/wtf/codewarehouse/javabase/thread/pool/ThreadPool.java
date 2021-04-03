package com.wtf.codewarehouse.javabase.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 实现简单的线程池
 * 生产者-消费者
 */
public class ThreadPool {

    /**
     * 阻塞队列
     */
    BlockingQueue<Runnable> taskQueue;

    /**
     * 工作线程集合
     */
    List<Thread> threads = new ArrayList<Thread>();

    /**
     * 线程池构造方法
     *
     * @param poolSize
     * @param taskQueue
     */
    ThreadPool(int poolSize, BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;

        for (int i = 0; i < poolSize; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    Runnable task;
                    try {
                        task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            threads.add(t);
        }
    }

    void execute(Runnable task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
