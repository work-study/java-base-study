package com.java.code.study.juc.book.book08.thread02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 11:56 2018/12/6
 * @Modified By:
 */
public class TestMyThreadPool {

    public static void main(String[] args) {
        List<Future<String>> resultList = new ArrayList<>();
        for (int i=0;i<10;i++) {
            Future<String> future = ThreadPoolForTest.getInstance(10)
                    .submit(new MyTask(i,"zouwei"+i));
            resultList.add(future);
        }
        resultList.forEach((x)->{
            try {
                String s = x.get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
