package com.java.code.study.juc.base.thread10;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 14:39 2018/12/3
 * @Modified By:
 */
public class MyThread10_02 extends Thread {
    public MyThread10_02(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<5; i++) {
                Thread.sleep(3);
                System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+ ")" +", loop "+i);
            }
        } catch (InterruptedException e) {
        }
    }
}
