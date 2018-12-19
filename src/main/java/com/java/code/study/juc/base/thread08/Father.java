package com.java.code.study.juc.base.thread08;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 13:34 2018/12/3
 * @Modified By:
 */
public class Father extends Thread {
    @Override
    public void run() {
        Son s = new Son();
        s.start();
        try {
            System.out.println("join before");
            s.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join after");
    }
}
