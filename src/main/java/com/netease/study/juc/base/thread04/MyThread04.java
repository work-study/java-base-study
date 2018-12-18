package com.netease.study.juc.base.thread04;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 17:31 2018/11/30
 * @Modified By:
 */
public class MyThread04 extends Thread {
    public MyThread04(String name) {
        super(name);
    }

    public MyThread04() {
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop Thread " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }
}
