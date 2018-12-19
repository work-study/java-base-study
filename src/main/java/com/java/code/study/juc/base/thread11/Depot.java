package com.java.code.study.juc.base.thread11;

import lombok.Data;
import lombok.ToString;

// 仓库
@Data
@ToString
public class Depot {
    /**
     * 仓库的容量
     * */
    private int capacity;
    /**
     * 仓库的实际数量
     * */
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val) {
        int left = val;
        while (left > 0) {
            while (size >= capacity) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("product wait()");
                }
            }
            int inc = (size+left)>capacity ? (capacity-size) : left;
            size +=inc;
            left -=inc;
            System.out.println("生产成功 inc："+inc);
            notifyAll();
        }

    }

    public synchronized void consume(int val) {
        try {
            int left = val;
            while (left > 0) {
                while (size <= 0) {
                    wait();
                }
                int dec = (size<left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.println("消费成功 dec："+dec);
                notifyAll();
            }
        } catch (InterruptedException e) {
        }
    }
}