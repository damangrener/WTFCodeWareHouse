package com.wtf.codewarehouse.javabase;

/**
 * @author wangtengfei
 * @since 2020/7/23 11:32
 */
public class IntegerAndInt {

    public static void main(String[] args) {
        Integer i1=100;
        Integer i2=100;
        Integer i3=200;
        Integer i4=200;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
        System.out.println(i3.equals(i4));

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;
        System.out.println(d1==d2);
        System.out.println(d3==d4);
        System.out.println(d3.equals(d4));
    }
}
