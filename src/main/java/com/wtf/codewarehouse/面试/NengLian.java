package com.wtf.codewarehouse.面试;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public class NengLian {
    /**
     * 1.	对于一个给定的字符串，我们需要在线性时间，
     * 也就是O(n)的时间里对它做一些变形。首先这个字符串中包含着一些空格，
     * 就像"Hello World"一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，
     * 同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
     * <p>
     * String reverseOrderAndCase(String input) {
     */
    static String reverseOrderAndCase(String input) {
        char[] chars=input.toCharArray();
        StringBuilder sb=new StringBuilder("");
        for (int i = 0; i <chars.length; i++) {
            if(Character.isLowerCase(chars[i])){
                chars[i]=Character.toUpperCase(chars[i]);
            }else{
                chars[i]=Character.toLowerCase(chars[i]);
            }
            sb.append(chars[i]);
        }
//        input=Character.
        String[] arr = sb.toString().split(" ");
        String[] resultArr = new String[arr.length];
        int i = 0;
        int j = arr.length-1;
        while (i < arr.length) {
            if (j>=0) {
                resultArr[i] = arr[j];
                j--;
                i++;
            }
        }
        return StringUtils.join(resultArr," ");
    }

    public static void main(String[] args) {
        System.out.println(reverseOrderAndCase("Hello World"));
    }
}
