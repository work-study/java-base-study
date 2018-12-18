package com.netease.study.juc.base.thread11;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 14:52 2018/12/3
 * @Modified By:
 */
public class Customer{
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int val) {
        new Thread() {
            @Override
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}
