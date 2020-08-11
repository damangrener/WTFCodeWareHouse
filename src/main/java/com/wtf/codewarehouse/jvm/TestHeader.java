package com.wtf.codewarehouse.jvm;

import com.wtf.codewarehouse.serialization.Person;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author wangtengfei
 * @since 2020/8/10 19:15
 */
public class TestHeader {
    public static void main(String[] args) {
        Person p=new Person();
        int hashCode=p.hashCode();
        System.out.println(hashCode);
        System.out.println(Integer.toHexString(hashCode));
        print(p);
        for (int i = 0; i <15 ; i++) {
            System.gc();

        }
        print(p);
    }
    static void print(Person p){
        System.err.println(ClassLayout.parseInstance(p).toPrintable());

    }
}
