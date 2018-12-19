package com.java.code.study.juc.base.thread09;

/**
 * 在中断里面使用break进行终止线程
 */
public class MyThread09_04 extends Thread {

    public MyThread09_04(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                System.out.println("i:" + i + ":" + Thread.currentThread().getName());
            } catch (Exception ie) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
                break;
            }
            i++;
        }
    }
}
