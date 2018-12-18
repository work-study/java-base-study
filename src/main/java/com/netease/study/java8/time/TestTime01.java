package com.kaola.netease.base.java8.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestTime01 {
    @Test
    public void test01() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ExecutorService service = Executors.newFixedThreadPool(10);
        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20181111");
            }
        };
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Date> submit = service.submit(callable);
            list.add(submit);
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
    }

    @Test
    public void test02() throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        ExecutorService service = Executors.newFixedThreadPool(10);
        Callable<LocalDate> callable = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20181111",dtf1);
            }
        };
        List<Future<LocalDate>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<LocalDate> submit = service.submit(callable);
            list.add(submit);
        }
        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }
    }
}
