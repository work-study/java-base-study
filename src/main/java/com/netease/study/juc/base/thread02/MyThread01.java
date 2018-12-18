package com.netease.study.juc.base.thread02;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:56 2018/11/30
 * @Modified By:
 */
// RunnableTest.java 源码
public class MyThread01 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
};