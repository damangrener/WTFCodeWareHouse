package com.wtf.codewarehouse.jvm;

/**
 * VM Args：-Xss128k
 * @author wangtengfei
 * @since 2020/8/11 16:53
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom=new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
