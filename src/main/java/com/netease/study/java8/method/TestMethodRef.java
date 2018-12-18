package com.kaola.netease.base.java8.method;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * 方法引用：若lambda体中的内容方法已经实现了，我们可以使用方法引用
 * 主要有三中语法格式
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
* */
public class TestMethodRef {

    //对象::实例方法名
    @Test
    public void test01() {
        Consumer<String> consumer = (x)-> System.out.println(x);
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("aaaaaaaaaaaaaaaaaa");
    }

    //类::静态方法名
    @Test
    public void test02() {
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        comparator.compare(1,2);
        Comparator<Integer> comparator1 = Integer::compare;
        comparator1.compare(1,2);
    }

    //类::实例方法名
    @Test
    public void test03() {
        BiPredicate<String,String> biPredicate = (x,y)->x.equals(y);
        biPredicate.test("aa","bb");
        //第一个参数是方法的调用者，第二个参数是方法的参数才可以使用，类::实例方法名
        BiPredicate<String,String> biPredicate1 = String::equals;
    }
}
