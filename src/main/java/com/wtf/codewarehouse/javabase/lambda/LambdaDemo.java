package com.wtf.codewarehouse.javabase.lambda;

import com.wtf.codewarehouse.mysql.po.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangtengfei
 * @since 2020/7/28 17:14
 */
public class LambdaDemo {
    public static void main(String[] args) {
        User user1 = new User(1, "wtf-01", 21, "wtf", 0, null, null);
        User user2 = new User(2, "wtf-02", 18, "wtf", 0, null, null);
        User user3 = new User(3, "wtf-03", 5, "wtf", 0, null, null);
        User user4 = new User(4, "wtf-04", 22, "wtf", 0, null, null);
        User user5 = new User(5, "wtf-05", 22, "wtf", 0, null, null);
        User user6 = new User(6, "wtf-06", 9, "wtf", 0, null, null);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        /**
         * sorted正序，不会对原生list做出改变，需用新list接
         */
        users.stream().sorted(Comparator.comparing(x -> x.getAge()));
        users.forEach(x -> System.out.println(x.toString()));
        System.out.println("======sorted正序，不会对原生list做出改变，需用新list接");
        users.stream().sorted(Comparator.comparing(User::getAge));
        users.forEach(x -> System.out.println(x.toString()));
        System.out.println("======");
        List<User> userList = users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        userList.forEach(x -> System.out.println(x.toString()));
        System.out.println("======sorted倒序");
        List<User> userListDesc = users.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        userListDesc.forEach(x -> System.out.println(x.toString()));
        /**
         * sort正序，会对原生list做出改变
         */
        System.out.println("======sort正序，会对原生list做出改变");
        users.sort(Comparator.comparing(User::getAge));
        users.forEach(x -> System.out.println(x.toString()));
        System.out.println("======sort倒序");
        users.sort(Comparator.comparing(User::getAge).reversed());
        users.forEach(x -> System.out.println(x.toString()));
        System.out.println("======");
    }
}
