package com.wtf.codewarehouse.util;

/**Be a good sport
 * 做一个有风度的人
 * @author wangtengfei
 * @since 2020/8/10 11:55
 */
public class LongSwitchGBKBMB {

    /**
     * long类型转换为GB、MB、KB
     * @param size
     * @return
     */
    public  String convertFileSize(long size) {
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
