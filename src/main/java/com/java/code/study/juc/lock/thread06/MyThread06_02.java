package com.java.code.study.juc.lock.thread06;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 15:46 2018/12/4
 * @Modified By:
 */
public class MyThread06_02 extends Thread {
    private Lock lock;
    private Condition condition;
    public MyThread06_02(String name, Lock lock, Condition condition) {
        super(name);
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " wakup others");
            Thread.sleep(1000);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}