package com.wtf.codewarehouse.jvm;

import com.wtf.codewarehouse.javabase.thread.NameList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/8/7 9:33
 */
public class Student {

    private String name;

    static NameList nameList = null;

    static{
        nameList = new NameList();
    }

    public Student(String name){
        this.name=name;
    }


    public Student() {
    }

    public static class Test{
        public static void main(String[] args) {
            //s1、s2、s3为不同对象
            /**
             * 引用放在栈里，具体的实例放在堆里
             */
            Student s1 = new Student("zsr");
            Student s2 = new Student("gcc");
            Student s3 = new Student("BareTH");
            System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
            System.out.println(s3.hashCode());

            Class<? extends Student> class1=s1.getClass();
            Class<? extends Student> class2=s2.getClass();
            Class<? extends Student> class3=s3.getClass();
            try {
                Class clazz = Class.forName(Student.class.getName(),false,Thread.currentThread().getContextClassLoader());
                Student student = (Student)clazz.newInstance();
                System.out.println(student.nameList);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            System.out.println(class1.hashCode());
            System.out.println(class2.hashCode());
            System.out.println(class3.hashCode());
            /**
             * s1、s2、s3的hashcode是不同的，因为是三个不同的对象，对象是具体的
             * class1、class2、class3的hashcode是相同的，因为这是类模板，模板是抽象的
             * 同一个类的不同对象hashCode一致
             */
            Class<? extends LinkedList> class4=new LinkedList<Student>().getClass();
            Class<? extends ArrayList> class5=new ArrayList<Student>().getClass();
            Class<? extends List> class6=new LinkedList<Student>().getClass();
            System.out.println(class4.hashCode());
            System.out.println(class5.hashCode());
            System.out.println(class6.hashCode());
        }
    }
}

