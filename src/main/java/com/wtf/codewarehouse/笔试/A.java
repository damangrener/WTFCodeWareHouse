package com.wtf.codewarehouse.笔试;

public class A {
    public A(){

    }
    public A(int x){}

    public void methodA(int y){}

    private int x=0;
    static int y=1;
    protected int z=2;

    public void methodA()
    {
        System.out.println(10%3) ;
    }

    public static void main(String[] args) {
//        int i=1;
//        int j=i++;
//        System.out.println(i);
//        System.out.println(j);
        int i, j, sum = 0;
        int a[][] = new int[][]{{100,2,3,},{4,5,6},{17,8,9}};
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                a[i][j] = (i+j)%2==0? a[i][j] :0    ;
                sum+=a[i][j];
            }
        }
//输出二维数组
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
//显示对角线之和
        for (i = 0; i < 3; i++) {
            sum = sum     ;
        }
        System.out.println("对角线之和：" + sum);
    }

}
