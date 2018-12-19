package com.java.code.study.java8.stream;

import com.java.code.study.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI01 {
    //通过Collection集合的stream()方法或者parallStream()
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> stringStream = list.parallelStream();
    }
    //Arrays中的静态方法stream()得到数组流
    @Test
    public void test02() {
        Employee[] employees = new Employee[10];
        Stream<Employee> stream = Arrays.stream(employees);
    }

    //通过Stream静态方法of()
    @Test
    public void test04() {
      Stream<String> stream = Stream.of("a","b","c");
    }

    //4、创建无限流
    @Test
    public void test05() {
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);
    }
}
