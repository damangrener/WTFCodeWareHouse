package com.wtf.codewarehouse.javabase.深浅拷贝;

public class Person implements Cloneable {

    private int pid;
    private String name;
    private Person p;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Person(int pid, String name, Person person) {
        this.pid = pid;
        this.name = name;
        this.p = person;
        System.out.println("Person constructor");
    }

    public Person(int pid, String name) {
        this.pid = pid;
        this.name = name;
        System.out.println("Person constructor");
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", p=" + p +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
