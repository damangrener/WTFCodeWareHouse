package com.wtf.codewarehouse.javabase.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author wangtengfei
 * @since 2020/8/5 11:29
 */
public class Person implements Iterable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private List<Person> children = new ArrayList<Person>();

    @Override
    public Iterator<Person> iterator() {
        return children.iterator();
    }

    public int hashCode() {
        return firstName.hashCode() & lastName.hashCode() & age;
    }


    public Person(String fn, String ln, int a, Person... kids) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
        for (Person child : kids)
            children.add(child);
    }

    public Person(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public String toString() {
        return "[Person: " +
                "firstName=" + firstName + " " +
                "lastName=" + lastName + " " +
                "age=" + age + "]";
    }
}

/**
 * 清单 2. 增强的 for 循环：显示孩子
 */
class App {
    public static void main(String[] args) {
        Person ted = new Person("Ted", "Neward", 39,
                new Person("Michael", "Neward", 39),
                new Person("Matthew", "Neward", 39));

        for (Person kid : ted
        ) {
            System.out.println(kid.getFirstName());
        }
    }
}

/**
 * 清单 3. ReverseIterator
 */
class ReverseIterator {
    public static void main(String[] args) {
        Person ted = new Person("Ted", "Neward", 39,
                new Person("Michael", "Neward", 39),
                new Person("Matthew", "Neward", 39));
        List<Person> kids = new ArrayList<>(ted.getChildren());
        Collections.reverse(kids);
        System.out.println(kids);

    }
}

/**
 * 可变 hashCode() 容易出现 bug
 * 永远不要将可变对象类型用作 HashMap 中的键。
 */
class MissingHash {
    public static void main(String[] args) {
        Person p1 = new Person("Ted", "Neward", 39);
        Person p2 = new Person("Charlotte", "Neward", 38);
        System.out.println(p1.hashCode());
        Map<Person, Person> map = new HashMap<Person, Person>();
        map.put(p1, p2);
//        p1.setLastName("Finkelstein");
        System.out.println(p1.hashCode());

        System.out.println(map.get(p1));
    }
}