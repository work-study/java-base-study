package com.netease.study.juc.base.thread04;

import org.junit.Test;

/**
 * 本章，会对synchronized关键字进行介绍。涉及到的内容包括：
 * 1. synchronized原理
 * 2. synchronized基本规则
 * 3. synchronized方法 和 synchronized代码块
 * 4. 实例锁 和 全局锁
 */
public class TestSyn01 {

    /**
     * 1. synchronized原理
     *  1）：在java中，每一个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在。
     2）：当我们调用某对象的synchronized方法时，就获取了该对象的同步锁。
     例如，synchronized(obj)就获取了“obj这个对象”的同步锁。
     3）：不同线程对同步锁的访问是互斥的。也就是说，某时间点，对象的同步锁只能被一个线程获取到！
     通过同步锁，我们就能在多线程中，实现对“对象/方法”的互斥访问。
     例如，现在有两个线程A和线程B，它们都会访问“对象obj的同步锁”。
     假设，在某一时刻，线程A获取到“obj的同步锁”并在执行一些操作；
     而此时，线程B也企图获取“obj的同步锁” —— 线程B会获取失败，它必须等待，
     直到线程A释放了“该对象的同步锁”之后线程B才能获取到“obj的同步锁”从而才可以运行。
     * */

    /**
     * 2. synchronized基本规则
     * 我们将synchronized的基本规则总结为下面3条，并通过实例对它们进行说明。
     * 1）：第一条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
     *      其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
     * 2）：第二条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
     *      其他线程仍然可以访问“该对象”的非同步代码块。
     * 3）：第三条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
     *      其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
     */


    /**
     * 第一条例子：
     * 结果说明
     * run()方法中存在“synchronized(this)代码块”，而且t1和t2都是基于"demo这个Runnable对象"创建的线程。
     * 这就意味着，我们可以将synchronized(this)中的this看作是“demo这个Runnable对象”；
     * 因此，线程t1和t2共享“demo对象的同步锁”。
     * 所以，当一个线程运行的时候，另外一个线程必须等待“运行线程”释放“demo的同步锁”之后才能运行。
     */
    @Test
    public void test01() throws InterruptedException {
        Runnable r1 = () -> {
            synchronized (this) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + " loop " + i);
                    }
                } catch (InterruptedException ie) {
                }
            }
        };
        // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t1 = new Thread(r1, "t1");
        // 新建“线程t2”, t2是基于demo这个Runnable对象
        Thread t2 = new Thread(r1, "t2");
        t1.start();
        t2.start();
        t2.join();
    }

    @Test
    public void test02() throws InterruptedException {
        // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t1 = new MyThread04("t1");
        // 新建“线程t2”, t2是基于demo这个Runnable对象
        Thread t2 = new MyThread04("t2");
        t1.start();
        t2.start();
        t2.join();
    }

    /**
     * 第二条例子：
     */
    @Test
    public void test03() throws InterruptedException {
        Count count = new Count();
        Thread t1 = new Thread(count::synMethod);
        Thread t2 = new Thread(count::nonSynMethod);

        t1.start();
        t2.start();
        t2.join();

    }

    /**
     * 第三条：
     */
    @Test
    public void test04() throws InterruptedException {
        Count01 count = new Count01();
        Thread t1 = new Thread(count::synMethod);
        Thread t2 = new Thread(count::nonSynMethod);

        t1.start();
        t2.start();
        t2.join();

    }

    /**
     * 3. synchronized方法 和 synchronized代码块
     */

    @Test
    public void test05() {
        Count count = new Count();
        long start, diff;
        start = System.currentTimeMillis();
        count.testSynBloack();
        diff = System.currentTimeMillis() - start;
        System.out.println("synMethod() : " + diff);

        start = System.currentTimeMillis();
        count.testSynBloack();
        diff = System.currentTimeMillis() - start;
        System.out.println("synBlock()  : " + diff);
    }

    /**
     * 4、实例锁 和 全局锁
     *
     * 实例锁 -- 锁在某一个实例对象上。
     *           如果该类是单例，那么该锁也具有全局锁的概念。
     实例锁对应的就是synchronized关键字。
     全局锁 -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。
     全局锁对应的就是static synchronized（
     或者是锁在该类的class或者classloader对象上）。
     例如：com.netease.study.juc.base.thread04.Something
     假设，Something有两个实例x和y。分析下面4组表达式获取的锁的情况。
     (01) x.isSyncA()与x.isSyncB()
     (02) x.isSyncA()与y.isSyncA()
     (03) x.cSyncA()与y.cSyncB()
     (04) x.isSyncA()与Something.cSyncA()
     * */


    /**
     * (01) 不能被同时访问。
     */
    Something x = new Something();
    Something y = new Something();

    @Test
    public void test06() throws InterruptedException {
        Thread t1 = new Thread(x::isSyncA);
        Thread t2 = new Thread(x::isSyncB);
        t1.start();
        t2.start();
        t2.join();
        t1.join();
    }

    /**
     * (02) 可以同时被访问
     */
    @Test
    public void test07() throws InterruptedException {
        Thread tt1 = new Thread(x::isSyncA);
        Thread tt2 = new Thread(y::isSyncA);
        tt1.start();
        tt2.start();
        tt2.join();
        tt1.join();
    }

    /**
     * (03) 不能被同时访问
     */
    @Test
    public void test08() throws InterruptedException {
        Thread tt1 = new Thread(Something::cSyncA);
        Thread tt2 = new Thread(Something::cSyncB);
        tt1.start();
        tt2.start();
        tt2.join();
        tt1.join();
    }

    /**
     * (04) 可以被同时访问
     */
    @Test
    public void test09() throws InterruptedException {
        Thread tt1 = new Thread(x::isSyncA);
        Thread tt2 = new Thread(Something::cSyncB);
        tt1.start();
        tt2.start();
        tt2.join();
        tt1.join();
    }


}
