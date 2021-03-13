package com.wtf.codewarehouse.util.number.transfer;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author wangtengfei
 * @since 2020/12/15 11:31
 */
public class NumberUtil {


    /**
     * 小数转百分比
     * 0.5678->56.78%
     * 四舍五入
     */
    public static String decimalConvertIntoTwoPercent(Object object){
        checkNull(object);
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format(object);

    }

    /**
     * 百分数的值转小数
     * 56.78->0.5678
     */
    public static BigDecimal percentConvertIntoDecimal(Object object){
        return new BigDecimal(null == object ? "0" : String.valueOf(Double.parseDouble(object.toString())/100));
    }

    private static void checkNull(Object object){
        if(null==object){
            throw new NullPointerException("数值转换入参不能为空");
        }
    }

    private static void ifNullDefaultZero(Object object){
        if(null==object){
            object="0";
        }
    }

    public static void main(String[] args) {
        double a=1.23456d;
        System.out.println(NumberUtil.decimalConvertIntoTwoPercent(a).substring(0,NumberUtil.decimalConvertIntoTwoPercent(a).length()-1).replace("%",""));
        //.replace("%","")
    }

}
