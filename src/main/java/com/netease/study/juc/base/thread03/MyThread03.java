package com.netease.study.juc.base.thread03;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:54 2018/11/30
 * @Modified By:
 */
public class MyThread03 extends Thread {
    public MyThread03() {
        super();
    }

    public MyThread03(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":runing");
    }
}
