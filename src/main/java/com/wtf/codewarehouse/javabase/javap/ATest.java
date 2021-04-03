package com.wtf.codewarehouse.javabase.javap;

/**
 * @Author: WTF
 * @Date: 2021/1/27 11:15
 */
public class ATest {


    public static void main(String[] args) {
        ATest aTest = new ATest();
        int a = 1;
        int b = 2;

        int c = aTest.add(a, b);

        int d = 0;

        c = d;
    }

    public synchronized int add(int a, int b) {
        return a + b;
    }
}
