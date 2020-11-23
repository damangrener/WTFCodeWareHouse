package com.wtf.codewarehouse.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtengfei
 * @since 2020/8/11 17:20
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用set保持着常量池引用，避免FullGC回收常量池行为
//        Set<String> set=new HashSet<>();
//        //
//        short i=0;
//        while (true){
//            set.add(String.valueOf(i++).intern());
//        }

        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);

    }
}
