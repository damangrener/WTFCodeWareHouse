package com.wtf.codewarehouse.jvm;

import org.omg.SendingContext.RunTime;

/**
 * @author wangtengfei
 * @since 2020/8/10 11:45
 */
public class TestJVM {
    public static void main(String[] args) {
        //jvm试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();
        //jvm内存总量
        long total = Runtime.getRuntime().totalMemory();
        System.out.println(convertFileSize(max));
        System.out.println(convertFileSize(total));
    }

    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        //%.2f 即是保留两位小数的浮点数，后面跟上对应单位就可以了，不得不说java很方便
        if (size >= gb) {
            return String.format("%.2f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            //如果大于100MB就不用保留小数位啦
            return String.format(f > 100 ? "%.1f MB" : "%.2f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            //如果大于100kB就不用保留小数位了
            return String.format(f > 100 ? "%.0f KB" : "%.2f KB", f);
        } else
            return String.format("%d B", size);
    }
}
