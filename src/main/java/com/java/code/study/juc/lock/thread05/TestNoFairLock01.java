package com.java.code.study.juc.lock.thread05;

/**
 本章小结：
 https://www.cnblogs.com/skywang12345/p/3496651.html
 1、获取非公平锁
 2、释放非公平锁
 */
public class TestNoFairLock01 {

    /**
     * 1、获取非公平锁
     * 现在直接获取，如果没有用使用就直接获取了。不想公平锁没人用还要到哦队列里面排队。
     * final void lock() {
         if (compareAndSetState(0, 1))
            setExclusiveOwnerThread(Thread.currentThread());
         else
            acquire(1);
     }
     *
     * */



}
