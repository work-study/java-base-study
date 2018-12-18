package com.netease.study.juc.lock.thread07;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * 本章小结：
 * 1）：LockSupport介绍
 * 2）：LockSupport函数列表
 * 3）：LockSupport参考代码
 * 4）：LockSupport示例
 */
public class TestLockSupport01 {
    private static Thread mainThread;
    /**
     * 4、LockSupport示例
     */
    public static void main(String[] args) {
        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " start ta");
        ta.start();
        System.out.println(Thread.currentThread().getName() + " block");
        // 主线程阻塞
        LockSupport.park(mainThread);
        System.out.println(Thread.currentThread().getName() + " continue");
    }
    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);
        }
    }

}
