package com.wtf.codewarehouse.算法.稀疏数组;

public class SparseArray {

    public static void main(String[] args) {

        //创建一个原始的二维数组11*11
        //0无子，1黑子，2蓝子
        int[][] originArray = new int[11][11];
        originArray[1][2] = 1;
        originArray[2][3] = 2;
//        for (int i = 0; i < originArray.length; i++) {
//            for (int j = 0; j < originArray[i].length; j++) {
//                System.out.printf("%d\t",originArray[i][j]);
//            }
//            System.out.println();
//        }
        int sum = 0;
        for (int[] row : originArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println(sum);

        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = originArray.length;
        sparseArray[0][1] = originArray[0].length;
        sparseArray[0][2] = sum;

        //给稀疏数组赋值
        int row = 1;
        for (int i = 0; i < originArray.length; i++) {
            int line = 0;
            for (int j = 0; j < originArray[i].length; j++) {
                if (originArray[i][j] != 0) {
                    sparseArray[row][line] = i;
                    line++;
                    sparseArray[row][line] = j;
                    line++;
                    sparseArray[row][line] = originArray[i][j];
                    row++;
                    if (row > sum) {
                        break;
                    }
                }
            }
        }

        //打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println();
        }

        int[][] originArrayBySparse=new int[sparseArray[0][0]][sparseArray[0][1]];

    }
}
