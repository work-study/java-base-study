package com.java.code.study.java8.stream;

import com.java.code.study.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestStreamAPI03 {
    List<Employee> employeeList = Arrays.asList(
            new Employee("zw01",18,3000),
            new Employee("zw02",20,4000.99),
            new Employee("zw03",30,5000.99),
            new Employee("zw04",40,10000.99),
            new Employee("zw05",45,9999.99)
    );
    @Test
    public void test01() {
        employeeList.stream();
    }
}
