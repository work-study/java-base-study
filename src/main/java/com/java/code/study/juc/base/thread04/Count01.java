package com.java.code.study.juc.base.thread04;

public class Count01 {

    // 含有synchronized同步块的方法
    public void synMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " count 01 synMethod loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }

    public void nonSynMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }
}