package com.wtf.codewarehouse.算法.稀疏数组.aaa递归;

public class HanoiTower {


    /**
     * 盘子A-》C
     *
     * @param n 总共有n个盘子
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
        } else {
            hanoi(n-1,A,C,B);
            System.out.println(A + "->" + B);
            hanoi(n,B,A,C);
        }
    }
}
