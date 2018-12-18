package com.netease.study.juc.base.thread11;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 14:52 2018/12/3
 * @Modified By:
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }
    public void produce(int val) {
        new Thread() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}
