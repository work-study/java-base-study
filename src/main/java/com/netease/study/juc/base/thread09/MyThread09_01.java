package com.netease.study.juc.base.thread09;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 14:02 2018/12/3
 * @Modified By:
 */
public class MyThread09_01 extends Thread {
    public MyThread09_01(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
            }
        } catch (InterruptedException e) {
            System.out.println("自己的中断标志：" + this.isInterrupted());
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
        }
    }
}
