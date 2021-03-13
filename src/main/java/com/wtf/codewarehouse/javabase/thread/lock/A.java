package com.wtf.codewarehouse.javabase.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class A {

    int num = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public long getNum() {
//        return num;
        return atomicInteger.get();
    }


//    public synchronized void increase(){
//        num++;
//    }
    // ||等价于
//    public void increase() {
//        synchronized (this) {
//            num++;
//        }
//    }

    public void increase() {
        atomicInteger.incrementAndGet();

        while(true){
            //做++之前
            int oldValue=atomicInteger.get();
            int newValue=oldValue+1;
            //拿出旧值跟内存里面的值做对比
            if(atomicInteger.compareAndSet(oldValue,newValue)){
                break;
            }
        }
    }

}
