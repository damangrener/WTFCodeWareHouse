package com.wtf.codewarehouse.javabase.deadlock;

/**
 * @author wangtengfei
 * @since 2020/7/24 16:25
 */
public class DeadLock {
    public static final String LOCK_1 = "lock1";
    public static final String LOCK_2 = "lock2";

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                while (true) {
                    synchronized (DeadLock.LOCK_1) {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                        synchronized (DeadLock.LOCK_2){
                            System.out.println(Thread.currentThread().getName());
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
