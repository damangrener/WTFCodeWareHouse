package com.wtf.codewarehouse.javabase.anonymousclasses;

/**
 * x = 23
 * this.x = 1
 * ShadowTest.this.x = 0
 * @author wangtengfei
 * @since 2020/8/3 14:49
 */
public class ShadowTest {
    public int x = 0;

    class FirstLevel {
        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
