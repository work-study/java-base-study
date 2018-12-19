package com.java.code.study.java8.optional;

import com.java.code.study.java8.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

public class TestOptional01 {
    @Test
    public void test01() {
        Optional<Employee> op = Optional.of(new Employee());
        System.out.println("1:"+op.get());
        /*Optional<Employee> op1 = Optional.of(null);
        System.out.println(op1.get());*/
       /* Optional<Employee> op2 = Optional.empty();
        System.out.println(op2.get());*/
       /* Optional<Employee> op3 = Optional.ofNullable(null);
        System.out.println(op3.get());*/
        Optional<Employee> op4 = Optional.of(new Employee());
        if (op4.isPresent()) {
            System.out.println("isPresent:"+op4.get());
        }
        Optional<Employee> op5 = Optional.of(new Employee("zzz",12,12.2));
        Optional<Employee> op6 = Optional.ofNullable(null);
        System.out.println("2:"+op5.orElse(new Employee()));
        System.out.println("3:"+op6.orElse(new Employee()));
        System.out.println("4:"+op5.orElseGet(Employee::new));
        System.out.println("5:"+op6.orElseGet(Employee::new));
    }

    @Test
    public void test02() {
        Optional<Employee> op = Optional.ofNullable(new Employee("zzz",12,12.2));
        Optional<String> stringOptional = op.map((e) -> e.getName());
        System.out.println(stringOptional.get());

        Optional<String> optional = op.flatMap((e) -> Optional.ofNullable(e.getName()));
        System.out.println(optional.get());
    }
}
