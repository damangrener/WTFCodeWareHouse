package com.wtf.codewarehouse.util.collections;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
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
        //3、写法3
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
     * 【取出B集合不在A集合中的差集】
     * @param aList a集合
     * @param bList b集合
     * @return 两个集合的差集
     */
    public static List<String> differenceOfTwoList(List<String> aList, List<String> bList) {
        return aList.stream().filter(x->!bList.contains(x)).collect(Collectors.toList());
    }

    /**
     * 集合转字符串，符号分割
     * @param list 不能为空 [1,2,3]
     * @return "1,2,3"
     */
    public static String listTransferString(List<String> list){
        // 1 写法1
        StringUtils.join(list,",");
        // 2 写法2 利用guava的Joiner
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
        return Splitter.on(",").splitToList(str);
        //等价于

    }

    /**【分组】
     * 集合多字段分组，采用字符串拼接作为key
     * x -> x.getA() + "_" + x.getB() 分组的字段
     */
    public static Map<String, List<DemoClass>> groupByList(List<DemoClass> list) {
        Map<String, List<DemoClass>> result =
                list.stream()
                        .collect(
                                Collectors.groupingBy(
                                        x -> x.getA() + "_" + x.getB()
                                ));
        return result;
    }

    /**
     * 取出符合条件的字段
     *
     * @param list
     */
    public static Object getFromListByCondition(List<DemoClass> list, Object condition) {
        Object result = list.stream()
                .filter(x -> x.getA().equals(condition))
                .findFirst().orElse(new DemoClass()).getB();
        return result;
    }

    /**【求和】
     * 求出集合中符合条件的某个字段的和
     *
     * @param list
     */
    public static Integer sumSingleFieldFromListByConditions(List<DemoClass> list, Object condition) {
        Integer sum = list.stream()
                .filter(y -> (null != y.getA()
                        && y.getA().equals(condition))
                ).mapToInt(DemoClass::getB).sum();
        return sum;
    }

    /**【去重】
     * 集合指定字段去重
     * @param list
     * @return
     * o.getA() + "_" + o.getB() 指定去重的条件
     */
    public static List distinctList(List<DemoClass> list) {
        List<DemoClass> result = list.stream().
                collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                        new TreeSet<>(
                                Comparator.comparing(o -> o.getA() + "_" + o.getB()))
                ), ArrayList::new));
        return result;
    }


    public static void show(List<Object> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        List<String> aList = Lists.newArrayList("aaa", "bbb", "ccc", "ddd");
//        List<String> bList = Lists.newArrayList("aaa", "aba", "bbb", "dba");
//
//        List<String> result = CollectionUtils.intersectionOfTwoList(aList, bList);
//        CollectionUtils.show(result);

//        DemoClass a=new DemoClass("a",1);
//        DemoClass a1=new DemoClass("a",1);
//        DemoClass b=new DemoClass("b",1);
//        DemoClass b1=new DemoClass("b",2);
//
//        List<DemoClass> list=new ArrayList<>();
//        list.add(a);
//        list.add(a1);
//        list.add(b);
//        list.add(b1);
//        CollectionUtils.show(CollectionUtils.distinctList(list));

        List<String> l1=Splitter.on(",").splitToList("1,2,3,4,5,6,7,8,9,10,11,12,13,23,15,16,17,18,19,20,21,22,24,25,26,27,100,101,32,33,30,31,202,201,34,35,14,40,42,41,43,44,203,50,51,204,205,206,180,209,208,207,210,301,123,300,124,303,100056,211,305,1025,102,103,104");
        List<String> l2=Splitter.on(",").splitToList("9,10,11,12,15,18,20,30,31,35,41,102,103,104,123,124,180,201,202,203,207,209,211,301,303,900,901,100056,1,2,4,5,6,7,8,13,15,16,19,21,22,23,24,25,26,27,32,33,34,40,42,44,50,205,206,208,210,305,");

        System.out.println(l1);
        System.out.println(l2);

        List<String> l3=CollectionUtils.intersectionOfTwoList(l1,l2);
        System.out.println(l3);

        List<String> l4=l1.stream().filter(x->!l2.contains(x)).collect(Collectors.toList());
        System.out.println(l4);
    }
}
