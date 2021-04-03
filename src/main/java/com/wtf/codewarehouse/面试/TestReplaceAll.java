package com.wtf.codewarehouse.面试;

import java.util.regex.Pattern;

public class TestReplaceAll {
    public static void main(String[] args) {
        String s = "01234abcd";
        System.out.println(replaceAll("[a-z]", s, "CX"));
    }

    public static String replaceAll(String regex,String str,String replace){
        return Pattern.compile(regex).matcher(str).replaceAll(replace);
    }
}
