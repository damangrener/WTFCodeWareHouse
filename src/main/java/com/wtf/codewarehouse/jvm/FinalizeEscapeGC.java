package com.wtf.codewarehouse.jvm;

/**
 * 1. 对象可以在gc时自我拯救
 * 2. 这种自救的机会只有一次，因为一个对象的finalize()方法最多会被系统调用一次
 * @author wangtengfei
 * @since 2020/8/17 13:51
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive :)");

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        //自救失败
        SAVE_HOOK = null;
        System.gc();
        //因为Finalizer方法优先级很低，暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
