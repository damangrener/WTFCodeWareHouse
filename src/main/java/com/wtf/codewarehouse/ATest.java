package com.wtf.codewarehouse;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author wangtengfei
 * @since 2020/12/10 15:14
 */
public class ATest {

    public static String replaceSpace(String s) {
        String[] strs = s.split("\\[ \\]");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                sb.append(strs[i]);
            } else {
                sb.append("%20").append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static int[] exchange(int[] nums) {
        List<Integer> is = new ArrayList<>(nums.length);
        List<Integer> is1 = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                is.add(nums[i]);
            } else {
                is1.add(nums[i]);
            }
        }
        if (null != is1 && 0 < is1.size()) {
            is.addAll(is1);
        }
        return is.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
//        String s="   ";
//        System.out.println(s.replace(" ","%20"));
//        ATest.replaceSpace(s);

//        System.out.println(Integer.bitCount(3));
//
//        int[] nums=new int[]{1,2,3,5,7,4};
//
//        int p=0;

        Set<String> strings = Sets.newHashSetWithExpectedSize(20);
        List<String> strings1=Lists.newArrayListWithExpectedSize(20);
        for (int i = 0; i < 20; i++) {
            strings1.add("");
        }
        for (int i = 0; i < 20; i++) {
            strings.add("d:/aaa/bbb/ccc/" + (i + 1) + ".jpg");
        }
        strings.forEach(x -> {
            int a = 0;
            if (x.length() == 20) {
                a = Integer.parseInt(x.substring(15, 16));
            }
            if (x.length() == 21) {
                a = Integer.parseInt(x.substring(15, 17));
            }
            strings1.set(a-1, x);
        });
        strings1.forEach(System.out::println);
    }


}
