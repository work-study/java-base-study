package com.kaola.netease.base.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda03 {

    //对一个进行操作
    @Test
    public void test01() {
        Integer operation = operation(100, x -> x * x);
        System.out.println(operation);
        System.out.println(operation(200,x->x+200));
    }

    private Integer operation(Integer num,MyFun mf) {
        return mf.getVlaue(num);
    }
    List<Employee> employeeList = Arrays.asList(
            new Employee("zw01",18,3000),
            new Employee("zw02",20,4000.99),
            new Employee("zw03",30,5000.99),
            new Employee("zw04",40,6000.99),
            new Employee("zw05",45,9999.99)
    );

    //调用Collections.sort方法 通过比较两个Employee（按照年龄比，年龄相同按照姓名比）
    @Test
    public void test02() {
        Collections.sort(employeeList,(e1,e2)->{
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge()-e2.getAge();
            }
        });
    }

    //声明一个函数式接口：MyFun2
    //实现该接口，把字符串小写变成大写
    @Test
    public void test03() {
        MyFun2 myFun2 = x->x.toUpperCase();
        System.out.println(myFun2.getValue("aaaaaaaaaaaaaaaaaaaaaaaaa"));
        MyFun2 myFun21 = x->x.substring(2,4);
        System.out.println(myFun21.getValue("123456789"));
    }

    //实现函数式接口myfun3
    @Test
    public void test04() {
        MyFun3<Long,Long> myFun3 = (x,y)->x+y;
        System.out.println(operationLong(100L,200L,myFun3));
    }
    private  Long operationLong(Long arg1,Long arg2,MyFun3<Long,Long> mf) {
        return mf.operation(arg1,arg2);
    }
}
