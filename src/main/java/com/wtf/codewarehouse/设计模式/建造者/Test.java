package com.wtf.codewarehouse.设计模式.建造者;

/**
 * @author wangtengfei
 * @since 2020/10/15 15:33
 */
public class Test {

    public static void main(String[] args) {
        MilkTea milkTea = new MilkTea.MilkTeaBuilder()
                .ice(false)
                .pearl(true)
                .type("coco")
                .size("大")
                .build();
        System.out.println(milkTea.toString());

    }
}
