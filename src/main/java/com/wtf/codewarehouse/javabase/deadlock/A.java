package com.wtf.codewarehouse.javabase.deadlock;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/8/27 15:14
 */
@Data
public class A {
    private String name;

    public static void main(String[] args) {
        A a=new A();
        A b=new A();
        b.setName(a.getName());
        System.out.println(b.getName());
    }
}

