package com.wtf.codewarehouse.jvm;

import java.util.ArrayList;

/**
 * @author wangtengfei
 * @since 2020/8/10 13:46
 */
public class TestDump {
        byte[] array = new byte[1024 * 1024];//1M

        public static void main(String[] args) {
            ArrayList<TestDump> list = new ArrayList<>();
            int count = 0;
            try {
                while (true) {
                    list.add(new TestDump());
                    count++;
                }
            } catch (Exception e) {
                System.out.println("count=" + count);
                e.printStackTrace();
            }
    }
}
