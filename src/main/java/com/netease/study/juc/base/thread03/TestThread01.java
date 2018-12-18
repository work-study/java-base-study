package com.netease.study.juc.base.thread03;

import com.netease.study.juc.base.thread02.MyThread;
import org.junit.Test;

/**
 * 本章主要内容：
 * 1）：start() 和 run()的区别说明
 * start() : 它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
 * run()   : run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！
 * 2）：start() 和 run()的区别示例
 * 3）：start() 和 run()相关源码(基于JDK1.7.0_40)
 * 可以自己到jdk读取看看
 */
public class TestThread01 {

    /**
     * 结果：main call mythread.run()
     * main:runing
     * main call mythread.start()
     * mythread:runing
     * 结果说明：
     * (01) Thread.currentThread().getName()是用于获取“当前线程”的名字。当前线程是指正在cpu中调度执行的线程。
     * (02) mythread.run()是在“主线程main”中调用的，该run()方法直接运行在“主线程main”上。
     * (03) mythread.start()会启动“线程mythread”，“线程mythread”启动之后，会调用run()方法；此时的run()方法是运行在“线程mythread”上。
     */
    @Test
    public void test01() throws InterruptedException {
        Thread mythread = new MyThread03("mythread");
        System.out.println(Thread.currentThread().getName() + " call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName() + " call mythread.start()");
        mythread.start();
        mythread.join();
    }
}
