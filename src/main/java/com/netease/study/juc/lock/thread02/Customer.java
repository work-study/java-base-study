package com.netease.study.juc.lock.thread02;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:38 2018/12/3
 * @Modified By:
 */
public class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}
