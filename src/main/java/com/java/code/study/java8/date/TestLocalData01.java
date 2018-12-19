package com.java.code.study.java8.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 19:33 2018/12/4
 * @Modified By:
 */
public class TestLocalData01 {
    @Test
    public void test01() {
        // 取当前日期：
        LocalDate today = LocalDate.now();
        System.out.println("当前日期：" + today);
        // 根据年月日取日期：
        LocalDate crischristmas = LocalDate.of(2014, 12, 25);
        System.out.println("当前初始化的时间：" + crischristmas);
        // 根据字符串取：// 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
        System.out.println("当前初始化的时间：" + endOfFeb);
        // 无效日期无法通过：DateTimeParseException: Invalid date
        try {
            LocalDate.parse("2014-02-29");
        } catch (Exception e) {
            System.out.println("异常");
        }
        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("取本月第1天：" + firstDayOfThisMonth);
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println("取本月第2天：" + secondDayOfThisMonth);
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("取本月最后一天：" + lastDayOfThisMonth);
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        System.out.println("取下一天：" + firstDayOf2015);
        // 取2017年1月第一个周一，用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("取2017年1月第一个周一：" + firstMondayOf2015);
    }
}
