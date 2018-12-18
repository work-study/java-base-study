package com.netease.study.juc.book.book08.thread02;

import lombok.ToString;

import java.util.concurrent.Callable;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 11:56 2018/12/6
 * @Modified By:
 */
@ToString
public class MyTask implements Callable {

    private Integer id;
    private String name;

    public MyTask(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        return this.toString();
    }
}
