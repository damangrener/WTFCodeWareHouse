package com.wtf.codewarehouse.javabase.thread;

/**
 * java.lang.Thread
 * @author wangtengfei
 * @since 2020/7/29 12:10
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //模拟一个非常耗时的操作
            for(long k=0;k<100000000;k++);
            System.out.println(name+":"+i);
        }
    }

}
class TestRunnable{
    public static void main(String[] args) {
        MyRunnable my1=new MyRunnable("李白");
//        MyRunnable my2=new MyRunnable("屈原");

        Thread t1=new Thread(my1);
//        Thread t2=new Thread(my2);

        t1.start();
//        t2.start();
    }
}

