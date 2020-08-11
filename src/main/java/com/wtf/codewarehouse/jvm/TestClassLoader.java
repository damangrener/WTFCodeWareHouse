package com.wtf.codewarehouse.jvm;

/**
 * @author wangtengfei
 * @since 2020/8/8 10:45
 */
public class TestClassLoader {
    public static void main(String[] args) {
        Student s=new Student("zsr");
        Class<? extends Student> c=s.getClass();
        ClassLoader classLoader=c.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
