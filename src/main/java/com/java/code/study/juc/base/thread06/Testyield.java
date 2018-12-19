package com.java.code.study.juc.base.thread06;

import org.junit.Test;

/**
 * 本章主要内容：
 * 1. yield()介绍
 * yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；
 * 但是，并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可能是当前线程又进入到“运行状态”继续运行！
 * 2. yield()示例
 * 3. yield() 与 wait()的比较
 */
public class Testyield {

    /**
     * 2、yield示例
     */
    @Test
    public void test01() throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    /**
     * 3. yield() 与 wait()的比较
     * 我们知道，wait()的作用是让当前线程由“运行状态”进入“等待(阻塞)状态”的同时，也会释放同步锁。而yield()的作用是让步，它也会让当前线程离开“运行状态”。它们的区别是：
     (01) wait()是让线程由“运行状态”进入到“等待(阻塞)状态”，而不yield()是让线程由“运行状态”进入到“就绪状态”。
     (02) wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。
     * */
}
