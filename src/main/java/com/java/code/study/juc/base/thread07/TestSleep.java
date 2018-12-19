package com.java.code.study.juc.base.thread07;

import org.junit.Test;

/**
 * 本章主要内容：
 * 1. sleep()介绍
 * 1）：sleep() 定义在Thread.java中。
 * 2）：sleep() 的作用是让当前线程休眠，即当前线程会从“运行状态”进入到“休眠(阻塞)状态”。
 * 3）：sleep()会指定休眠时间，线程休眠的时间会大于/等于该休眠时间；在线程重新被唤醒时，它会由“阻塞状态”变成“就绪状态”，从而等待cpu的调度执行。
 * 2. sleep()示例
 * 3. sleep() 与 wait()的比较
 */
public class TestSleep {
    @Test
    public void test() throws InterruptedException {
        Thread t1 = new MyThread07_01("t1");
        t1.start();
        t1.join();
    }
}
