package com.java.code.study.juc.base.thread06;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 11:30 2018/12/3
 * @Modified By:
 */
public class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            // i整除4时，调用yield
            if (i % 4 == 0) {
                Thread.yield();
            }
        }
    }
}
