package com.wtf.codewarehouse.面试;

import java.util.HashSet;
import java.util.Set;

public class WeiMingNaoNao {

    public static void main(String[] args) {
        Set<String> set = method();
        set.forEach(x -> System.out.println(x));
        System.out.println(set.size());
    }

    /**
     * 1.请写一段算法，输出100个数字比较大小的公式，这些公式里有50%是正确的，50%是错误的，
     * 具体哪个是正确的还是错误的，这个是随机的（注意，不是交叉的，而是随机的）。
     * 每个公式内的数字是随机的。例子如下：
     * 9<3 2>1 8>3 7<9 6>2 4<5 …
     * 其中第一个公式9<3是错误的，第二个公式2>1是正确的，第三个公式8>3是正确的，第四个公式7<9是正确的。
     */
    public static Set<String> method() {
        Set<String> resultSet = new HashSet<>(100);
        //初始的随机数
        int init = ((int) (Math.random() * (200 - 1))) + 1;
        int trueNum = 0;
        int falseNum = 0;
        //随机次数，因为存在数特别小时随机数造成的死循环问题，为了避免，两次还没随机出来的直接处理
        int randomTimes = 1;
        while (resultSet.size() < 100) {
            int i = ((int) (Math.random() * (200 - 1))) + 1;
            if (trueNum < 50 && i < init) {
                if (randomTimes > 2) {
                    i = init - 1;
                }
                resultSet.add(i + "<" + init);
                init = i;
                trueNum++;
                randomTimes = 1;
            }
            if (falseNum < 50 && i > init) {
                if (randomTimes > 2) {
                    i = init + 1;
                }
                resultSet.add(i + ">" + init);
                init = i;
                falseNum++;
                randomTimes = 1;
            }
            randomTimes++;
        }
        System.out.println("trueNum: " + trueNum);
        System.out.println("falseNum: " + falseNum);
        return resultSet;
    }
}
