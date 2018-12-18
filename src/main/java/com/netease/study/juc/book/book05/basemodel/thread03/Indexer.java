package com.netease.study.juc.book.book05.basemodel.thread03;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 17:17 2018/12/5
 * @Modified By:
 */
public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
