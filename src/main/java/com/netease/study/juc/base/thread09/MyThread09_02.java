package com.netease.study.juc.base.thread09;

/**
 * 在中断里面使用break进行终止线程
 */
public class MyThread09_02 extends Thread {

    public MyThread09_02(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
                break;
            }
            i++;
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
        }
    }
}
