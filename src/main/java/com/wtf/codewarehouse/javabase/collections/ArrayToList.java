package com.wtf.codewarehouse.javabase.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/8/5 10:36
 */
public class ArrayToList {
    public static void main(String[] args) {
        System.out.println(args);

        List<String> argList= Arrays.asList(args);
        /**
         * 注意：Arrays.asList返回的list是不可变的：java.lang.UnsupportedOperationException
         * Arrays.asList()返回的ArrayList继承自AbstractList，它仅支持那些不会改变数组大小的操作，
         * 所以任何对底层数据结构的尺寸进行修改的方法都会出现异常，Arrays.asList()返回固定尺寸的List。
         * https://blog.csdn.net/oYeYuanXinZhiZhu1/article/details/79952592
         */
//        argList.add("1");
        System.out.println(argList);
        List<String> variableArgList=new ArrayList<>(Arrays.asList(args));
        variableArgList.add("1");
        System.out.println(variableArgList);
    }
}
