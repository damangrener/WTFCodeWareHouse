package com.wtf.codewarehouse.面试;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,31));

        int i = 5;
        switch (i) {
            default:
                System.out.println("default");
                break;
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
//            case 5:
//                System.out.println(5);
//                break;
        }
    }
}
