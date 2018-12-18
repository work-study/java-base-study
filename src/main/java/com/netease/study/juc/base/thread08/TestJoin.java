package com.netease.study.juc.base.thread08;

import org.junit.Test;

/**
 * 本章，会对Thread中join()方法进行介绍。涉及到的内容包括：
 * 1. join()介绍
 * 2. join()源码分析(基于JDK1.7.0_40)
 * 3. join()示例
 */
public class TestJoin {

    /**
     * 1. join()介绍
     * join() 定义在Thread.java中。
     * join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。这句话可能有点晦涩，我们还是通过例子去理解：
     */
    @Test
    public void test01() throws InterruptedException {
        Father father = new Father();
        father.start();
        father.join();
    }

    /**
     * 2. join()源码分析,
     * 3. join()示例
     * 具体流程自己分析或者参考package-info博客
     */
    @Test
    public void test02() throws InterruptedException {
        Father father = new Father();
        father.start();
        father.join();
    }
}
