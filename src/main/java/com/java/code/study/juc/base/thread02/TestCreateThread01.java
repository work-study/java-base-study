package com.java.code.study.juc.base.thread02;

import org.junit.Test;

/**
 * 本章的主要内容：
 * 1）：Thread和Runnable的简介
 * 2）：Thread和Runnable的异同点
 * Thread 和 Runnable 的相同点：都是“多线程的实现方式”。
 * Thread 和 Runnable 的不同点：
 * Thread 是类，而Runnable是接口；Thread本身是实现了Runnable接口的类。我们知道“一个类只能有一个父类，但是却能实现多个接口”，
 * 因此Runnable具有更好的扩展性。
 * 此外，Runnable还可以用于“资源的共享”。即，多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。
 * 通常，建议通过“Runnable”实现多线程！
 * 3）：Thread和Runnable的多线程的示例
 */
public class TestCreateThread01 {

    /**
     * 1. Thread的多线程示例
     */
    @Test
    public void test() {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 2. Runnable的多线程示例
     */
    @Test
    public void test02() {
        MyThread mt = new MyThread();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        t1.start();
        t2.start();
        t3.start();
    }
}
