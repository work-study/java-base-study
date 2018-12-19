package com.java.code.study.juc.book.book06.thread03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 10:38 2018/12/6
 * @Modified By:
 */
public class InvokeAllThread02 {

    public static void main(String[] args) throws InterruptedException {
        testInvokeAllThread();
    }
    public  static void testInvokeAllThread() throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
        Callable<Integer> task = null;
        for (int i = 0; i < 20; i++) {
            task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int ran = new Random().nextInt(1000);
                    Thread.sleep(ran);
                    System.out.println(Thread.currentThread().getName()
                            + " 休息了 " + ran);
                    return ran;
                }
            };

            tasks.add(task);
        }

        long s = System.currentTimeMillis();

        //不设置超时时间
        List<Future<Integer>> results = exec.invokeAll(tasks);

        System.out.println("执行任务消耗了 ：" + (System.currentTimeMillis() - s)
                + "毫秒");

        for (int i = 0; i < results.size(); i++) {
            try {
                System.out.println(results.get(i).get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        exec.shutdown();
    }
}
