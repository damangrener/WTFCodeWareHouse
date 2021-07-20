package com.wtf.codewarehouse.面试;

public class NianLi {
    public static void main(String[] args) {
        byte[] result = addThree(new byte[]{9, 8});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 3. 大数算数
     * 用数组或链表表示一个巨大的正整数 n（例如 23487293847192308479），计算
     * n*(n+3)的结果
     * 例如：
     * n=2，输出 10
     * n=2999999999999，输出 9000000000002999999999998
     * n=329491759821798177583275，输出
     * 108564819790465535825168530615921458114092475450
     */
    public static int[] multiply(String multiplier) {
        char[] multiplierArr = multiplier.toCharArray();

        return null;
    }

    public static byte[] addThree(byte[] arr) {
        if (arr[arr.length - 1] + 3 < 10) {
            arr[arr.length - 1] = (byte) (arr[arr.length - 1] + 3);
            return arr;
        } else {
            arr[arr.length - 1] = (byte) ((arr[arr.length - 1] + 3) / 10);
            for (int i = arr.length - 2; i >= 0; i--) {
                method(i, arr);
            }
        }
        return arr;
    }

    static void method(int i, byte[] arr) {
        //最左进位
        if (i == 0) {

        }
        arr[i] = (byte) (arr[i] + 1);
        if (arr[i] > 10) {
            if(arr[0]==10){
                byte[] newArr = new byte[arr.length + 1];
                newArr[0] = 1;
                for (int j = 1; j < newArr.length; j++) {
                    newArr[j] = arr[j - 1];
                }
                arr = newArr;
                return;
            }
            method(i - 1, arr);
        }
    }
}
