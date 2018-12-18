package com.kaola.netease.base.java8.lambda;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、Lambda表达式的基本语法，引入jiantou（->）操作符，分成左侧和右侧
 *
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式所需要执行的功能，lambda体
 * 语法格式一: 无参也无返回值
 *          ()->System.out.println("hello world")
 * 语法格式二：有一个参数无返回值
 * 语法格式三：若参数只有一个参数小括号可以省略不写
 * 语法格式四：多个参数并且lambda实现体有多行,实现体必须有{}
 * 语法格式五：若Lambda实现体只有一条语句，return和{}都可以省略
 * 语法格式六：Lambda表达式的参数类型可以省略不写，因为JVM编译器上下文推断出类型。
 *
 *二、lambda表达式需要函数式接口的支持
 * 接口里面只有一个抽象方法时就称为函数式接口，可以使用@FunctionalInterface,可以檢查是不是函數是接口
 * */
public class TestLambda02 {
    //语法格式一: 无参也无返回值
    @Test
    public void test01() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        runnable.run();
        Runnable runnable1 = ()-> System.out.println("hello world");
        runnable1.run();
    }
    //语法格式二：有一个参数无返回值
    //语法格式三：若参数只有一个参数小括号可以省略不写
    @Test
    public void test02() {
        Consumer<String> consumer = (x)-> System.out.println(x);
        Consumer<String> consumer1 = x-> System.out.println(x);
        consumer.accept("aaaaaaaaaaaaaaaaaaaa");
        consumer1.accept("bbbbbbbbbbbbbbbbbbbbbbb");
    }

    //语法格式四：多个参数并且lambda实现体有多行
    //语法格式五、若Lambda实现体只有一条语句，return和{}都可以省略
    @Test
    public void test03() {
        Comparator<Integer> comparator = (x,y)->{
            System.out.println("xxxxxxxxxxxx");
            return x.compareTo(y);
        };
        Comparator<Integer> comparator1 = (x,y)->x.compareTo(y);
    }
}
