package com.wtf.codewarehouse.jvm;

/**
 * @author wangtengfei
 * @since 2020/8/17 10:53
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize=new byte[2*_1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a=new ReferenceCountingGC();
        a.testGC();
    }
    public static void testGC(){
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;

        System.gc();
    }

}
