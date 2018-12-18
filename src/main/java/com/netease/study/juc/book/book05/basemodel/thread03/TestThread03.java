package com.netease.study.juc.book.book05.basemodel.thread03;

import org.junit.Test;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 5.3、使用阻塞队列实现生产者和消费者模式
 */
public class TestThread03 {


    @Test
    public void test01() throws InterruptedException {
        File file = new File("D:\\repository");
        File[] files = file.listFiles();
        startIndexing(files);

        Thread.sleep(5000);
    }
    private static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingDeque<>(50);
        for (File root : roots) {
            new Thread(new FileCrawler(queue,(x)->true,root)).start();
        }
        for (int i=0;i<100;i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
