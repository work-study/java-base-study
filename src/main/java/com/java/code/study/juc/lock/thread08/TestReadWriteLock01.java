package com.java.code.study.juc.lock.thread08;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 本章小结：
    1）：ReadWriteLock 和 ReentrantReadWriteLock介绍
         ReadWriteLock，顾名思义，是读写锁。它维护了一对相关的锁 — — “读取锁”和“写入锁”，一个用于读取操作，另一个用于写入操作。
        “读取锁”用于只读操作，它是“共享锁”，能同时被多个线程获取。
        “ 写入锁”用于写入操作，它是“独占锁”，写入锁只能被一个线程锁获取。
        注意：不能同时存在读取锁和写入锁！
        ReadWriteLock是一个接口。ReentrantReadWriteLock是它的实现类，ReentrantReadWriteLock包括子类ReadLock和WriteLock。
    2）：ReadWriteLock 和 ReentrantReadWriteLock函数列表
    3）：ReentrantReadWriteLock数据结构
    4）：参考代码
        获取共享锁
        释放共享锁
        公平共享锁和非公平共享锁
    5）：ReentrantReadWriteLock示例
 */
public class TestReadWriteLock01 {

    /**
     * 3、ReentrantReadWriteLock数据结构
     *  (01) ReentrantReadWriteLock实现了ReadWriteLock接口。ReadWriteLock是一个读写锁的接口，
     *      提供了"获取读锁的readLock()函数" 和 "获取写锁的writeLock()函数"。
        (02) ReentrantReadWriteLock中包含：sync对象，读锁readerLock和写锁writerLock。读锁ReadLock和写锁WriteLock都实现了Lock接口。
            读锁ReadLock和写锁WriteLock中也都分别包含了"Sync对象"，它们的Sync对象和ReentrantReadWriteLock的Sync对象 是一样的，就是通过sync，
            读锁和写锁实现了对同一个对象的访问。
        (03) 和"ReentrantLock"一样，sync是Sync类型；而且，Sync也是一个继承于AQS的抽象类。
            Sync也包括"公平锁"FairSync和"非公平锁"NonfairSync。sync对象是"FairSync"和"NonfairSync"中的一个，默认是"NonfairSync"。
     * */

    /**
     * 4、代码分析
     *
     * */
    @Test
    public void testo1() throws InterruptedException {
        ReadWriteLock readWriteLock  = new ReentrantReadWriteLock();
        readWriteLock.writeLock().lock();
        readWriteLock.readLock().lock();
        Thread t1 = new Thread(()->{
            readWriteLock.readLock().lock();
        },"t1");
        Thread t2 = new Thread(()->{
            readWriteLock.readLock().lock();
        },"t2");
        Thread t3 = new Thread(()->{
            readWriteLock.readLock().lock();
        },"t3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
