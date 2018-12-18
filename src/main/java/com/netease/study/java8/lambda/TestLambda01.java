package com.kaola.netease.base.java8.lambda;

import org.junit.Test;

import java.util.*;

public class TestLambda01 {

    //匿名内部类
    @Test
    public void test01() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test02() {
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        TreeSet ts = new TreeSet(com);

    }

    //需求：获取当前公司员工年龄大于35的员工信息
    /**
     * 1、上面的需求正常使用for循环过滤，当需求变更的时候又要再写一个方法进行for循环过滤
     * 2、优化1：写一个接口返回boolean，写一个方法根据这个接口的返回值进行过滤，
     *           如果要实现某个需求增加一个实现了既可，这个是策略设计模式。
     * 3、优化2：在1的基础上面不需要实现接口了使用匿名内部类
     * 4、优化3：把匿名内部类使用lambda表达式进行实现过滤。
     * 5、优化4：使用stream
     * */
    List<Employee> employeeList = Arrays.asList(
            new Employee("zw01",18,3000),
            new Employee("zw02",20,4000.99),
            new Employee("zw03",30,5000.99),
            new Employee("zw04",40,6000.99),
            new Employee("zw05",45,9999.99)
    );
    @Test
    public void test03() {
        //第4点
        List<Employee> employees = filterEmployee(employeeList, (employee) -> employee.getSalary() > 5000);
        employees.forEach(System.out::println);
    }
    @Test
    public void test04() {
        //第5点,过滤然后打印
        employeeList.stream().filter((e)->e.getSalary()>5000).forEach(System.out::println);
        //过滤，取前两个然后打印
        employeeList.stream().filter((e)->e.getSalary()>5000).limit(2).forEach(System.out::println);

        //过滤把名字提取出来然后打印出来
        employeeList.stream().filter((e)->e.getSalary()>5000).map(Employee::getName).forEach(System.out::println);
    }
    private List<Employee> filterEmployee(List<Employee> employeeList,MyPredicate<Employee> mp) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (mp.test(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }
}
