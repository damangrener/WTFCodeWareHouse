package com.wtf.codewarehouse.javabase.collections;


import java.util.Arrays;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/8/6 11:29
 */
public class UsingSortedSet {
    public static void main(String[] args) {
        List<Person> personList=Arrays.asList(
                new Person("Ted", "Neward", 39),
                new Person("Ron", "Reynolds", 39),
                new Person("Charlotte", "Neward", 38),
                new Person("Matthew", "McCullough", 18)
        );
    }
}
