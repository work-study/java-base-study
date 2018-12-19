package com.java.code.study.juc.lock.thread02;

import org.junit.Test;

/**
 * 本章小结：
 1）：ReentrantLock介绍
 2）：ReentrantLock函数列表
 3）：ReentrantLock示例
 */
public class TestReentrantLock01 {
    /**
     * 1、ReentrantLock介绍
     * ReentrantLock是一个可重入的互斥锁，又被称为“独占锁”。
        顾名思义，ReentrantLock锁在同一个时间点只能被一个线程锁持有；而可重入的意思是，ReentrantLock锁，可以被单个线程多次获取。
        ReentrantLock分为“公平锁”和“非公平锁”。它们的区别体现在获取锁的机制上是否公平。
       “锁”是为了保护竞争资源，防止多个线程同时操作线程而出错，ReentrantLock在同一个时间点只能被一个线程获取(当某线程获取到“锁”时，
        其它线程就必须等待)；ReentraantLock是通过一个FIFO的等待队列来管理获取该锁所有线程的。
        在“公平锁”的机制下，线程依次排队获取锁；而“非公平锁”在锁是可获取状态时，不管自己是不是在队列的开头都会获取锁。
     * */
    /**
     * 2、ReentrantLock函数列表
     *  参考：源码或者 https://www.cnblogs.com/skywang12345/p/3496101.html
     *
     * */

    /**
     * 3、ReentrantLock示例
     * */

    @Test
    public void test01() {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);

        //while (true);
    }


}
