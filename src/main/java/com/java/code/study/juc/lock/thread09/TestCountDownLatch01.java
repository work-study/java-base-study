package com.java.code.study.juc.lock.thread09;

import java.util.concurrent.CountDownLatch;

/**
 * 本章小结：
     1、CountDownLatch简介
        CountDownLatch和CyclicBarrier的区别
        (01) CountDownLatch的作用是允许1或N个线程等待其他线程完成执行；而CyclicBarrier则是允许N个线程相互等待。
        (02) CountDownLatch的计数器无法被重置；CyclicBarrier的计数器可以被重置后使用，因此它被称为是循环的barrier。
        关于CyclicBarrier的原理，后面一章再来学习。
     2、CountDownLatch数据结构
        里面有一个sync对象，sync继承了AQS
     3、CountDownLatch源码分析(基于JDK1.7.0_40)
     4、CountDownLatch示例
 */
public class TestCountDownLatch01 {
    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;
    public static void main(String[] args) {

        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);

            // 新建5个任务
            for(int i=0; i<LATCH_SIZE; i++) {
                new InnerThread().start();
            }

            System.out.println("main await begin.");
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();

            System.out.println("main await finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
