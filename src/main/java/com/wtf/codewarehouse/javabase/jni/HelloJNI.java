package com.wtf.codewarehouse.javabase.jni;

/**
 * https://www.cnblogs.com/ysocean/p/8476933.html
 * @author wangtengfei
 * @since 2020/7/29 14:59
 */
public class HelloJNI {

    private native void helloJNI();

    static {
        System.loadLibrary("helloJNI");
    }

    public static void main(String[] args) {
        HelloJNI jni=new HelloJNI();
        jni.helloJNI();
    }

}
