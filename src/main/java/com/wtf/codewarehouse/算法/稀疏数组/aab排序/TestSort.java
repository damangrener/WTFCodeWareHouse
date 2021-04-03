package com.wtf.codewarehouse.算法.稀疏数组.aab排序;

import java.util.Arrays;

public class TestSort {

    static int[] arr = new int[]{9, 8, 7, 5, 4, 3, 3, 2, 4, 1, 0};

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array, int start, int end) {
        //把数组中的第0个数作为标准树
        int standard = array[start];
        //记录需要排序的下标
        int low = start;
        int high = end;
        //循环找出比标准数大的数和比标准数小的数
        while (low < high) {
            //右边的数比标准数小
            while (low < high && standard <= array[high]) {
                high--;
            }
            //使用右边的数替换左边的数
            array[low] = array[high];
            while (array[low] <= standard) {
                low++;
            }
            array[high] = array[low];
        }
        //把标准书赋给低所在的位置的元素
        array[low] = standard;
        quickSort(array, start, low);
        quickSort(array, low + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
