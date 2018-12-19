package com.java.code.study.juc.base.thread10;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 14:43 2018/12/3
 * @Modified By:
 */
public class MyDaemon extends Thread {
    public MyDaemon(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(1);
                System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
            }
        } catch (InterruptedException e) {
        }
    }
}
