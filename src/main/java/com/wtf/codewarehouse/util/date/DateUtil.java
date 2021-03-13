package com.wtf.codewarehouse.util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author wangtengfei
 * @since 2020/11/24 16:15
 */
public class DateUtil {


    public static void main(String[] args) {
        LocalDate firstDay = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        LocalDateTime firstDayTime=LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),1,0,0,0);
        System.out.println(firstDay);
        System.out.println(firstDayTime);
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        LocalDate fDay = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(lastDay);
        System.out.println(fDay);

        /**
         * 获取昨天最早时间
         */
        LocalDateTime yesterdayFirstTime=LocalDateTime.of(
                LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(),
                LocalDateTime.now().minusDays(1L).getDayOfMonth(),
                0,0,0);
        System.out.println(yesterdayFirstTime);
        /**
         * 获取昨天最晚时间
         */
        LocalDateTime yesterdayLastTime=LocalDateTime.of(
                LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(),
                LocalDateTime.now().minusDays(1L).getDayOfMonth(),
                23,59,59);
        System.out.println(yesterdayLastTime);
    }


}
