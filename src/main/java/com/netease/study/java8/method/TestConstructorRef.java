package com.kaola.netease.base.java8.method;

import com.kaola.netease.base.java8.lambda.Employee;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 * 格式：
 * ClassName::new
 *
 * 数组引用
 * String[]::new
 *
* */
public class TestConstructorRef {

    @Test
    public void test01() {
        //默认引用get()方法参数列表取匹配构造器
        Supplier<Employee> supplier = Employee::new;
        Employee employee = supplier.get();
    }

    @Test
    public void test02() {
        //默认引用apply()方法参数列表取匹配构造器
        Function<Integer,Employee> function = Employee::new;
        Employee apply = function.apply(12);
        System.out.println(apply);
    }
}
