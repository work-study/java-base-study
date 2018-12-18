package com.netease.study.juc.base.thread10;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 14:39 2018/12/3
 * @Modified By:
 */
public class MyThread10_01 extends Thread {
    public MyThread10_01(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "(" + Thread.currentThread().getPriority() + ")"
                    + ", loop " + i);
        }
    }
}
