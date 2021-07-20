package com.wtf.codewarehouse.面试;

import com.google.common.collect.Lists;

import java.util.List;

public class RuiQi {

    static Integer maxArea(List<List<Integer>> a) {
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            int j = 0;
            ++result;
            while (a.get(j).equals(1) && j < a.get(i).size()) {
                ++result;
                while(a.get(i+1).get(j).equals(1)){
                    ++result;
                }

            }
            while (j - 1 > 0 && a.get(j - 1).equals(1) && j - 1 < a.get(i).size()) {
                ++result;
                while(a.get(i+1).get(j-1).equals(1)){
                    ++result;
                }
            }

            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> a= Lists.newArrayList(1, 0, 0, 1, 0);
        List<Integer> a1= Lists.newArrayList(1, 0, 1);
        List<Integer> a2= Lists.newArrayList(0, 0, 1, 0, 1);
        List<Integer> a3= Lists.newArrayList(1, 0, 1, 0, 1);
        List<Integer> a4= Lists.newArrayList(1, 0, 1, 1);

        List<List<Integer>> aa=Lists.newArrayList(a,a1,a2,a3,a4);
        System.out.println(maxArea(aa));
    }

}
