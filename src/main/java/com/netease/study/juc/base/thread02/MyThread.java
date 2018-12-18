package com.netease.study.juc.base.thread02;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:54 2018/11/30
 * @Modified By:
 */
public class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
};
