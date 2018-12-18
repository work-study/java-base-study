package com.netease.study.juc.lock.thread02;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:37 2018/12/3
 * @Modified By:
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}
