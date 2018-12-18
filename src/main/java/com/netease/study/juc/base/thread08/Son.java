package com.netease.study.juc.base.thread08;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 13:34 2018/12/3
 * @Modified By:
 */
public class Son extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + Thread.currentThread().getName());
        }
    }
}
