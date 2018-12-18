package com.netease.study.juc.lock.thread03;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 本章小结
 1）：基本概念
 2）：ReentrantLock数据结构
 3）：参考代码
 4）：获取公平锁
         一. tryAcquire()
         二. addWaiter()
         三. acquireQueued()
         四. selfInterrupt()
 */
public class TestReentrantLock01 {
    /**
     * 1、基本概念
        1. AQS -- 指AbstractQueuedSynchronizer类。
            AQS是java中管理“锁”的抽象类，锁的许多公共方法都是在这个类中实现。AQS是独占锁(例如，ReentrantLock)和共享锁(例如，Semaphore)的公共父类。
        2. AQS锁的类别 -- 分为“独占锁”和“共享锁”两种。
            (01) 独占锁 -- 锁在一个时间点只能被一个线程锁占有。根据锁的获取机制，它又划分为“公平锁”和“非公平锁”。公平锁，是按照通过CLH等待线程按照先来先得的规则，公平的获取锁；而非公平锁，则当线程要获取锁时，它会无视CLH等待队列而直接获取锁。独占锁的典型实例子是ReentrantLock，此外，ReentrantReadWriteLock.WriteLock也是独占锁。
            (02) 共享锁 -- 能被多个线程同时拥有，能被共享的锁。JUC包中的ReentrantReadWriteLock.ReadLock，CyclicBarrier， CountDownLatch和Semaphore都是共享锁。这些锁的用途和原理，在以后的章节再详细介绍。
        3. CLH队列 -- Craig, Landin, and Hagersten lock queue
            CLH队列是AQS中“等待锁”的线程队列。在多线程中，为了保护竞争资源不被多个线程同时操作而起来错误，我们常常需要通过锁来保护这些资源。在独占锁中，竞争资源在一个时间点只能被一个线程锁访问；而其它线程则需要等待。CLH就是管理这些“等待锁”的线程的队列。
            CLH是一个非阻塞的 FIFO 队列。也就是说往里面插入或移除一个节点的时候，在并发条件下不会阻塞，而是通过自旋锁和 CAS 保证节点插入和移除的原子性。
        4. CAS函数 -- Compare And Swap
            CAS函数，是比较并交换函数，它是原子操作函数；即，通过CAS操作的数据都是以原子方式进行的。例如，compareAndSetHead(), compareAndSetTail(), compareAndSetNext()等函数。它们共同的特点是，这些函数所执行的动作是以原子的方式进行的。
     * */

    /**
     *2、ReentrantLock数据结构
     *  (01) ReentrantLock实现了Lock接口。
        (02) ReentrantLock与sync是组合关系。ReentrantLock中，包含了Sync对象；而且，Sync是AQS的子类；更重要的是，Sync有两个子类FairSync(公平锁)和NonFairSync(非公平锁)。
                ReentrantLock是一个独占锁，至于它到底是公平锁还是非公平锁，就取决于sync对象是"FairSync的实例"还是"NonFairSync的实例"。
     * */

    /**
     * 4、获取公平锁
         一. tryAcquire()
         二. addWaiter()
         三. acquireQueued()
         四. selfInterrupt()
     * */
    @Test
    public void test01() {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
