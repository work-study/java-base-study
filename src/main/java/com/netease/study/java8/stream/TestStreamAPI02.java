package com.kaola.netease.base.java8.stream;

import com.kaola.netease.base.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI02 {
    List<Employee> employeeList = Arrays.asList(
            new Employee("zw01",18,3000),
            new Employee("zw02",20,4000.99),
            new Employee("zw03",30,5000.99),
            new Employee("zw04",40,10000.99),
            new Employee("zw05",45,9999.99)
    );
    @Test
    public void test01() {
        Stream<Employee> stream = employeeList.stream().filter((x) -> {
            System.out.println("xxxxxxxxxxxxxxx");
            return x.getAge() > 35;
        });

        //没有终止操作，中间操作不执行
        stream.forEach(System.out::println);

    }

    @Test
    public void test02() {
        employeeList.stream().map((x)->x.getName()).forEach(System.out::println);
        employeeList.stream().map((x)->x.getName().toUpperCase()).forEach(System.out::println);
    }
    @Test
    public void test03() {
        List<String> stringList = Arrays.asList("aaa","bbb","cccc");
        Stream<Stream<Character>> streamStream = stringList.stream().map(TestStreamAPI02::filterChar);
        streamStream.forEach((s)->s.forEach(System.out::println));

        stringList.stream().flatMap(TestStreamAPI02::filterChar).forEach(System.out::println);
    }
    @Test
    public void test04() {
        employeeList.stream().sorted((e1,e2)->{
            return e1.getAge()-e2.getAge();
        }).forEach(System.out::println);
    }

    private static Stream<Character> filterChar(String s) {
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
