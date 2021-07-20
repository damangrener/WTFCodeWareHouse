package com.wtf.codewarehouse.面试;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class RuiQi1 {

    static Integer maxArea(List<List<Integer>> a) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 1) {
                    list.add( add(a, i, j));
                }
            }
        }
//        System.out.println(list);
        return list.stream().max(Comparator.comparingInt(Integer::intValue)).get();
    }

    public static Integer add(List<List<Integer>> list, int i, int j) {
//        System.out.println(i + "   " + j + "  " + list.get(i).size());
        int result = 1;
        list.get(i).set(j, 0);
        //左
        if (j > 0 && list.get(i).get(j - 1).equals(1)) {
            result += add(list, i, j - 1);
        }
        //右
        if (j > 0 && j < list.get(i).size() - 1 && list.get(i).get(j + 1).equals(1)) {
            result += add(list, i, j + 1);
        }
        //上
        if (i > 0 && j < list.get(i - 1).size() && list.get(i - 1).get(j).equals(1)) {
            result += add(list, i - 1, j);
        }
        //下
        if (i > 0 && i < list.size() - 1 && j < list.get(i + 1).size() && list.get(i + 1).get(j).equals(1)) {
            result += add(list, i + 1, j);
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer> a = Lists.newArrayList(1, 0, 0, 1, 0);
        List<Integer> a1 = Lists.newArrayList(1, 0, 1);
        List<Integer> a2 = Lists.newArrayList(0, 0, 1, 0, 1);
        List<Integer> a3 = Lists.newArrayList(1, 0, 1, 0, 1);
        List<Integer> a4 = Lists.newArrayList(1, 0, 1, 1);
        List<List<Integer>> aa = Lists.newArrayList(a, a1, a2, a3, a4);
        System.out.println(maxArea(aa));
    }
}
