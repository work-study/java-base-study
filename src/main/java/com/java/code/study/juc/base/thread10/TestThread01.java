package com.java.code.study.juc.base.thread10;

import org.junit.Test;

/**
 * 本章小结：
 * 1. 线程优先级的介绍
 * 2. 线程优先级的示例
 * 3. 守护线程的示例
 */
public class TestThread01 {

    /**
     * 1. 线程优先级的介绍
     * 1）：java 中的线程优先级的范围是1～10，默认的优先级是5。“高优先级线程”会优先于“低优先级线程”执行。
     * 2）：java 中有两种线程：用户线程和守护线程。可以通过isDaemon()方法来区别它们：如果返回false，则说明该线程是“用户线程”；否则就是“守护线程”。
     * 用户线程一般用户执行用户级任务，而守护线程也就是“后台线程”，一般用来执行后台任务。需要注意的是：Java虚拟机在“用户线程”都结束后会后退出。
     * <p>
     * JDK 中关于线程优先级和守护线程的补充如下：
     * 当Java虚拟机启动时，通常有一个单一的非守护线程（该线程通过是通过main()方法启动）。JVM会一直运行直到下面的任意一个条件发生，JVM就会终止运行：
     * (01) 调用了exit()方法，并且exit()有权限被正常执行。
     * (02) 所有的“非守护线程”都死了(即JVM中仅仅只有“守护线程”)。
     */

    /**
     * 2. 线程优先级的示例
     */
    @Test
    public void test01() throws InterruptedException {
        Thread t1 = new MyThread10_01("t1");
        Thread t2 = new MyThread10_01("t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /**
     * 3. 守护线程的示例
     */
    @Test
    public void test02() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()
                + "(isDaemon=" + Thread.currentThread().isDaemon() + ")");
        Thread t1 = new MyThread10_02("t1");
        Thread t2 = new MyDaemon("t2");
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.join();
        // t2.join();
    }
}
