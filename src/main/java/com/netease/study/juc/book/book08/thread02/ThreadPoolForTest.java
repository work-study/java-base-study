package com.netease.study.juc.book.book08.thread02;

import java.util.concurrent.*;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 11:47 2018/12/6
 * @Modified By:
 */
public class ThreadPoolForTest {
    // 线程池最少线程数
    private static final int THREAD_POOL_CORE_SIZE = 5;
    // 最长等待时间
    private static final int THREAD_POOL_WAIT_SECONDS = 5 * 60;
    // 最大线程等待数
    private static final int THREAD_MAX_THREAD_WAIT = 2000;

    private ExecutorService exec;

    private static volatile ThreadPoolForTest instance;

    private ThreadPoolForTest(int maxThreadPool) {
        this.exec = new ThreadPoolExecutor(THREAD_POOL_CORE_SIZE,maxThreadPool,THREAD_POOL_WAIT_SECONDS, TimeUnit.SECONDS, new LinkedBlockingQueue<>(THREAD_MAX_THREAD_WAIT),new ThreadPoolExecutor.AbortPolicy());
    }

    public static ThreadPoolForTest getInstance(int maxThreadPool) {
        if (instance == null) {
            synchronized (ThreadPoolForTest.class) {
                if (instance == null) {
                    instance = new ThreadPoolForTest(maxThreadPool);
                }
            }
        }
        return instance;
    }

    public void exec(Runnable command) {
       exec.execute(command);
    }

    public <T> Future<T> submit(Callable<T> command) {
        return exec.submit(command);
    }

    public void shutdown() {
        exec.shutdown();
    }

    public boolean isTerminated() {
        return exec.isTerminated();
    }
}
