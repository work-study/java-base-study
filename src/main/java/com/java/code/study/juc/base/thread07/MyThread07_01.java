package com.java.code.study.juc.base.thread07;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 11:47 2018/12/3
 * @Modified By:
 */
public class MyThread07_01 extends Thread {
    public MyThread07_01(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: %d\n", this.getName(), i);
                // i能被4整除时，休眠100毫秒
                if (i % 4 == 0) {
                    System.out.println("sleep start.......");
                    Thread.sleep(1000);
                    System.out.println("sleep end ...........");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3. sleep() 与 wait()的比较
     * 我们知道，wait()的作用是让当前线程由“运行状态”进入“等待(阻塞)状态”的同时，也会释放同步锁。
     * 而sleep()的作用是也是让当前线程由“运行状态”进入到“休眠(阻塞)状态”。但是，wait()会释放对象的同步锁，而sleep()则不会释放锁。
     * */
}