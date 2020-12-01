package com.wtf.codewarehouse.javabase.lambda;

import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) {
        String contents="aeck,jdcj,nrec,iazzv,b";
        List<String> words=Arrays.asList(contents.split(","));
//        words.forEach(x-> System.out.println(x));
        //传统计数
        long count=0;
        for (String str:words
             ) {
            if(str.length()>2) count++;
        }
        System.out.println(count);

        //stream
        //顺序流
        count = words.stream().filter(x->x.length()>2).count();
        System.out.println(count);
        //并行流
        count = words.parallelStream().filter(x->x.length()>2).count();
        System.out.println(count);
    }
}
