package com.wtf.codewarehouse.javabase.深浅拷贝;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person pA=new Person(1,"pA");
        Person pB=new Person(1,"pB");
        Person p1=new Person(1,"p1",pA);
        System.out.println(pA);
        System.out.println(p1);
        Person p2= (Person) p1.clone();
        p2.setName("p2");
        p2.setP(pB);

        pB.setPid(10);
        System.out.println(p1);
        System.out.println(p2);
        int i=1;
        System.out.println(++i);
        System.out.println(i++);
    }
}
