package com.wtf.codewarehouse.javabase.deadlock;

import lombok.Data;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wangtengfei
 * @since 2020/8/27 15:14
 */
@Data
public class A {
    private String name;

    public static void main(String[] args) throws UnknownHostException {
        A a=new A();
        A b=new A();
        b.setName(a.getName());
        System.out.println(b.getName());

        String ipAddr="218.2.190.218";
        InetAddress inetAddr = InetAddress.getByName(ipAddr);
        ipAddr = inetAddr.getHostAddress();
        System.out.println(ipAddr);
    }

    protected void test() throws RuntimeException{

    }

    public class Test2 extends A{

//        @Override
//        private void test() throws ClassNotPreparedException{
//            super.test();
//        }
    }
}

