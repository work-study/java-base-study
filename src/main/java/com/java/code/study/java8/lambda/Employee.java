package com.java.code.study.java8.lambda;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {
    private String name;
    private int age;
    private double salary;
    private Status status;

    public Employee() {
    }

    public Employee(int age) {
        this.age = age;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    enum Status{
        FREE,
        BUSY
    }
}
