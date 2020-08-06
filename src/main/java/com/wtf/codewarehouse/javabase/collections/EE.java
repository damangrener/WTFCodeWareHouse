package com.wtf.codewarehouse.javabase.collections;

/**
 * @author wangtengfei
 * @since 2020/8/5 15:13
 */
public enum EE {
    MERCHANT_OWNER,
    ADMIN,
    STAFF
}
class A{
    public static void main(String[] args) {
        System.out.println("STAFF".equals(EE.STAFF.toString()));
    }
}
