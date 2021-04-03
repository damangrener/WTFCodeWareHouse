package com.wtf.codewarehouse.数据结构.f哈希表;


public class StudentInfo {

    private int age;
    private int count;

    public StudentInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    @Override
    public int hashCode() {
        return age;
    }

    public StudentInfo(int age) {
        this.age = age;
    }
    public StudentInfo() {
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
