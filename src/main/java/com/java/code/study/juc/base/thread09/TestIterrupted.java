package com.java.code.study.juc.base.thread09;

import org.junit.Test;

/**
 * 本章小结：
 * 1. interrupt()说明
 * 2. 终止线程的方式
 * 2.1 终止处于“阻塞状态”的线程
 * 2.2 终止处于“运行状态”的线程
 * 3. 终止线程的示例
 * 4. interrupted() 和 isInterrupted()的区别
 */
public class TestIterrupted {

    /**
     * 1、interrupt()说明
     * interrupt()的作用是中断本线程。
     1）：本线程中断自己是被允许的；其它线程调用本线程的interrupt()方法时，会通过checkAccess()检查权限。这有可能抛出SecurityException异常。
     2）：如果本线程是处于阻塞状态：调用线程的wait(), wait(long)或wait(long, int)会让它进入等待(阻塞)状态，或者调用线程的join(), join(long), join(long, int), sleep(long), sleep(long, int)也会让它进入阻塞状态。若线程在阻塞状态时，调用了它的interrupt()方法，那么它的“中断状态”会被清除并且会收到一个InterruptedException异常。例如，线程通过wait()进入阻塞状态，此时通过interrupt()中断该线程；调用interrupt()会立即将线程的中断标记设为“true”，但是由于线程处于阻塞状态，所以该“中断标记”会立即被清除为“false”，同时，会产生一个InterruptedException的异常。
     如果线程被阻塞在一个Selector选择器中，那么通过interrupt()中断它时；线程的中断标记会被设置为true，并且它会立即从选择操作中返回。
     如果不属于前面所说的情况，那么通过interrupt()中断线程时，它的中断标记会被设置为“true”。
     中断一个“已终止的线程”不会产生任何操作。
     * */


    /**
     * 2. 终止线程的方式
     *
     * */
    /**
     * 2.1 处于阻塞状态的中断
     * 当线程由于被调用了sleep(), wait(), join()等方法而进入阻塞状态；若此时调用线程的interrupt()将线程的中断标记设为true。
     * 由于处于阻塞状态，中断标记会被清除，同时产生一个InterruptedException异常。将InterruptedException放在适当的为止就能终止线程，形式如下：
     * Thread t1 = new Thread(()->{
     while (true) {
     try {
     // 执行任务...
     } catch (InterruptedException ie) {
     // InterruptedException在while(true)循环体内。
     // 当线程产生了InterruptedException异常时，while(true)仍能继续运行！需要手动退出
     break;
     }
     }
     });
     * */

    /**
     * 2.2 终止处于“运行状态”的线程
     * while (!isInterrupted()) {
     * // 执行任务...
     * }
     */
    @Test
    public void test01() {
        try {
            Thread t1 = new MyThread09_01("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");
            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println("中断标志：" + t1.isInterrupted());
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test02() {
        try {
            Thread t1 = new MyThread09_02("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        try {
            MyThread09_03 t1 = new MyThread09_03("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.stopTask();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4. interrupted() 和 isInterrupted()的区别
     * 最后谈谈 interrupted() 和 isInterrupted()。
     * interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。
     * 区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。
     */
    @Test
    public void test04() throws InterruptedException {
        Thread t1 = new MyThread09_04("t1");
        t1.start();
        System.out.println("t1:before:" + t1.isInterrupted());
        t1.interrupt();
        System.out.println("t1:before:" + t1.isInterrupted());
        System.out.println("currentThread:before:" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        //清除中断标志位
        System.out.println("currentThread:after1:" + Thread.interrupted());
        System.out.println("currentThread:after2:" + Thread.interrupted());
        System.out.println();
        System.out.println("t1:after:" + t1.isInterrupted());
        t1.join();
    }
}
