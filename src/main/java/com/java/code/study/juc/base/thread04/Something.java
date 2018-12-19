package com.java.code.study.juc.base.thread04;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 10:11 2018/12/3
 * @Modified By:
 */
public class Something {
    public synchronized void isSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : isSyncA:" + this);
            }
        } catch (InterruptedException ie) {
        }
    }

    public synchronized void isSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : isSyncB:" + this);
            }
        } catch (InterruptedException ie) {
        }
    }

    public static synchronized void cSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : cSyncA");
            }
        } catch (InterruptedException ie) {
        }
    }

    public static synchronized void cSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : cSyncB");
            }
        } catch (InterruptedException ie) {
        }
    }
}
