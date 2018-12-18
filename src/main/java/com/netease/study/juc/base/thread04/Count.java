package com.netease.study.juc.base.thread04;

public class Count {

    // 含有synchronized同步块的方法
    public void synMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }

    // 非同步的方法
    public void nonSynMethod() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
            }
        } catch (InterruptedException ie) {
        }
    }

    public synchronized void testSynMethod() {
        for (int i = 0; i < 1000000; i++) {

        }
    }

    public void testSynBloack() {
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {

            }
        }
    }
}