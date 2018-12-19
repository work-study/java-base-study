package com.java.code.study.juc.lock.thread06;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 15:46 2018/12/4
 * @Modified By:
 */
public class MyThread06_01 extends Thread {
    public MyThread06_01(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            notify();
        }
    }
}