package com.java.code.study.juc.base.thread09;

/**
 * 使用标志位进行终止线程
 */
public class MyThread09_03 extends Thread {
    private volatile boolean flag = true;

    public void stopTask() {
        flag = false;
    }

    public MyThread09_03(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                int i = 0;
                while (flag) {
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
                }
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
            }
        }
    }
}
