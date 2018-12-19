package com.java.code.study.juc.book.book06.thread03;

import java.util.concurrent.*;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 11:01 2018/12/6
 * @Modified By:
 */
public class TestCompletionService {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    private static CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
    public static void main(String[] args) {
        for (int j = 1; j <= 5; j++) {
            final int index = j;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //第三个线程睡眠等待
                    if (index == 3) {
                        java.lang.Thread.sleep(3000L);
                    }
                    return index;
                }
            });
        }
        threadPool.shutdown();
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("线程:" + completionService.take().get() + " 任务执行结束:");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
