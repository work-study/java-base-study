package com.java.code.study.java8.time;

import org.junit.Test;

import java.time.*;

public class TestTime02 {
    /**
     * LocalDate:日期，LocalTime:时间，LocalDateTime：时间日期
     */

    @Test
    public void test01() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("1:" + localDateTime);
        System.out.println("2:" + LocalDateTime.of(2015, 10, 19, 13, 22, 33, 20));
    }

    @Test
    public void test02() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusDays(2);
        System.out.println("plus:" + localDateTime1);
        LocalDateTime localDateTime2 = localDateTime.minusDays(2);
        System.out.println("minus:" + localDateTime2);

        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        int i = localDateTime2.compareTo(localDateTime);
        System.out.println("i:"+i   );
    }

    /**
     * 时间戳
     * */
    @Test
    public void test03() {
        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime offsetDateTime = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println("时间戳："+ins.toEpochMilli());
        System.out.println(Instant.ofEpochMilli(1000));
    }


    /**
     * 2个时间间隔,Duration
     * 2个日期之间的间隔，Period
     * */
    @Test
    public void test04() throws InterruptedException {
        Instant in1 = Instant.now();
        Thread.sleep(10);
        Instant in2 = Instant.now();
        System.out.println(Duration.between(in1,in2).getSeconds());
        System.out.println(Duration.between(in1,in2).toMillis());

        LocalDateTime ldt1 = LocalDateTime.now();
        Thread.sleep(10);
        LocalDateTime ldt2 = LocalDateTime.now();
        System.out.println(Duration.between(ldt1,ldt2).toMillis());


        //日期间隔
        LocalDate localDate1 = LocalDate.of(2015,1,1);
        LocalDate localDate2 = LocalDate.now();
        System.out.println(Period.between(localDate1,localDate2));
        System.out.println(Period.between(localDate1,localDate2).getYears());
        System.out.println(Period.between(localDate1,localDate2).getDays());
    }
}
