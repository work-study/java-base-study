package com.kaola.netease.base.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
* Java8 内置的4大核心函数式接口
 * Consumer<T>:消费型接口
 * Supplier<T>:供给型接口
 * Function<T,R>:函数型接口
 * Predicate<T>:断言式接口
* */
public class TestLambda04 {


    //Consumer<T>:消费型接口
    @Test
    public void test01() {
        happy(1000,(x)-> System.out.println("吃饭消费了"+x+"元"));
    }
    private void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
    //Supplier<T>:供给型接口,产生一些整数，并且放到集合里面
    @Test
    public void test02() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach((x)-> System.out.println(x));
    }
    private List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<num;i++) {
            list.add(supplier.get());
        }
        return list;
    }

    //Function<T,R>:函数型接口,处理字符串
    @Test
    public void test03() {
        String s = handler("aaaaaaaa", (x) -> x.toUpperCase());
        System.out.println(s);
        String s1 = handler("    aaaaaaaaassss", (x) -> x.trim());
        System.out.println(s1);
    }
    private String handler(String s, Function<String,String> function) {
        return function.apply(s);
    }


    //Predicate<T>:断言式接口,将满足条件字符串添加到集合中。
    @Test
    public void test04() {
        filterStr(null,null);
    }
    private List<String> filterStr(List<String> list, Predicate<String> predicate) {
        return list.stream().filter((x)->predicate.test(x)).collect(Collectors.toList());
    }
}
