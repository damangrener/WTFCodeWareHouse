package com.wtf.codewarehouse.数据结构.a数组;

import java.util.Arrays;

public class MyArrayList {

    //用于存储数据的数组
    private int[] elements;

    public MyArrayList() {
        elements = new int[0];
    }

    public int size() {
        return elements.length;
    }

    //打印数组所有元素
    public void show() {
        System.out.println(Arrays.toString(elements));
    }

    //添加元素
    public void add(int element) {
        //1.新建一个数组，长度为原数组长度+1
        int[] newArr = new int[elements.length + 1];
        //2.将原数组的数组复制到新数组中
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        //3.新数组最后一位赋值
        newArr[elements.length] = element;
        elements = newArr;
    }

    //删除元素
    public void delete(int index) {
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                newArr[i] = elements[i + 1];
            }
        }
        elements = newArr;
    }

    //替换指定位置元素
    public void set(int index, int element) {
        checkIndex(index);
        elements[index] = element;
    }

    //线性查找元素位置(第一次出现)
    public int getFirstIndex(int element) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    //线性查找元素位置(最后一次出现)
    public int getLastIndex(int element) {
        int index = -1;
        for (int i = elements.length - 1; i >= 0; i--) {
            if (elements[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    //二分法查找
    public int binarySearch(int element) {
        int begin = 0;
        int end = elements.length - 1;
        int mid = (begin + end) / 2;

        while (true) {
            if (begin > end) {
                return -1;
            }
            if (elements[mid] == element) {
                return mid;
            } else if (elements[mid] > element) {
                end = mid - 1;
            } else if (elements[mid] < element) {
                begin = mid + 1;
            }
            mid = (begin + end) / 2;
        }


    }

    private void checkIndex(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("indexOutOfBound");
        }
    }
}
