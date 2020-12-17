package com.wtf.codewarehouse.util.collections;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangtengfei
 * @since 2020/12/15 16:27
 */
public class CollectionUtils {


    /**
     * 【判断两个集合是否有交集】
     * 判断List<String> aList,List<String> bList 是否有交集
     * @param aList a集合
     * @param bList b集合
     */
    public static void isTwoListHaveIntersection(List<String> aList, List<String> bList) {
        //1、写法1
        aList.stream().filter(x -> bList.contains(x)).findFirst().isPresent();
        //2、写法2
        aList.stream().anyMatch(x -> bList.contains(x));
        //2、写法2
        aList.stream().anyMatch(bList::contains);
    }

    /**
     * 【取出两个集合的交集】
     * @param aList a集合
     * @param bList b集合
     * @return 两个集合的交集
     */
    public static List<String> intersectionOfTwoList(List<String> aList, List<String> bList) {
        if (aList.stream().noneMatch(bList::contains)) {
            return null;
        }
        return aList.stream().filter(bList::contains).collect(Collectors.toList());
    }

    /**
     * 集合转字符串，符号分割
     * @param list 不能为空 [1,2,3]
     * @return "1,2,3"
     */
    public static String listTransferString(List<String> list){
        // 1
        StringUtils.join(list,",");
        // 2 利用guava的Joiner
        return Joiner.on(",").join(list);
    }

    /**
     * 字符串转集合，符号分割
     * @param str "1,2,3"
     * @return [1,2,3]
     */
    public static List<String> StringTransferList(String str){
        // 1
        Arrays.asList(str.split(","));
        // 2 利用guava的Splitter
        return Splitter.on("|").splitToList(str);
        //等价于

    }

    public static void show(List<String> list) {
        list.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> aList = Lists.newArrayList("aaa", "bbb", "ccc", "ddd");
        List<String> bList = Lists.newArrayList("aaa", "aba", "bbb", "dba");

        List<String> result = CollectionUtils.intersectionOfTwoList(aList, bList);
        CollectionUtils.show(result);
    }
}
