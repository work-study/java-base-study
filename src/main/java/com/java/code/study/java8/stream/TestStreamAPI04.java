package com.java.code.study.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:21 2018/11/28
 * @Modified By:
 */
public class TestStreamAPI04 {

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    /**
     * 1、得到平均值
     */
    @Test
    public void test01() {
        System.out.println("testAveragingDouble");
        Optional<Double> collect = Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)));
        Optional<Double> collect1 = Optional.ofNullable(null);
        System.out.println(collect.orElseGet(() -> 1.0));
        System.out.println(collect.get());
        System.out.println(collect1.orElse(1.0));
    }

    @Test
    public void test02() {
        System.out.println("testAveragingInt");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    /**
     * 2、collectingAndThen操作
     */
    @Test
    public void test03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> v * 2),
                s -> s * s));
        System.out.println(result);
    }

    /**
     * 3、计算多少个元素
     */
    @Test
    public void test04() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        long result = list.stream().collect(Collectors.counting());
        System.out.println(result);
    }

    /**
     * 4、连接字符串，第一个参数元素之间，然后是前缀和后缀
     */
    @Test
    public void test05() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = list.stream().collect(Collectors.joining(",", "【", ")"));
        System.out.println(result);
    }

    /**
     * 5、得到最大值和最小值
     */
    @Test
    public void test06() {
        List<Integer> list = Arrays.asList(30, 10, 20, 35);
        //Get Max
        list.stream().collect(Collectors.maxBy(Integer::compare))
                .ifPresent(System.out::println);
        //Get Min
        list.stream().collect(Collectors.minBy(Integer::compare))
                .ifPresent(System.out::println);
    }

    /**
     * 对集合进行求和,还可以是其他类型
     */
    @Test
    public void test07() {
        List<Integer> list = Arrays.asList(30, 10, 20, 35);
        int result = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println(result);
    }

    /**
     * 变成其他集合
     */
    @Test
    public void test08() {
        List<String> list = Stream.of("AA", "BB", "CC").collect(Collectors.toList());
        list.forEach(System.out::println);
        Set<String> list1 = Stream.of("11", "22", "33").collect(Collectors.toSet());
        list1.forEach(System.out::println);
        Set<String> list2 = Stream.of("AA", "BB", "CC").collect(Collectors.toCollection(HashSet::new));
        list2.forEach(System.out::println);
        //里面的元素即作为key，也是value
        Map<String, String> map = Stream.of("AA", "BB", "CC").collect(Collectors.toMap(k -> k, v -> v + "aaa"));
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /**
     * 分组操作
     */
    @Test
    public void test09() {
        Map<String, List<Dish>> dish = menu.stream().collect(Collectors.groupingBy(Dish::getName));
        System.out.println("dish = " + dish);
        Map<String, Map<Integer, List<Dish>>> scoreNameUsers = menu.stream().collect(Collectors.groupingBy(Dish::getName, Collectors.groupingBy(Dish::getCalories)));
        System.out.println("scoreNameUsers = " + scoreNameUsers);

        Map<String, Dish> UserCount = menu.stream().collect(Collectors.groupingBy(Dish::getName, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("UserCount = " + UserCount);
    }

    /**
     * 分区操作，分成两个区，满足和不满足
     */
    @Test
    public void test10() {
        Map<Boolean, List<Dish>> jigeUsers = menu.stream().collect(Collectors.partitioningBy(user -> user.getCalories() >= 400));
        System.out.println("jigeUsers = " + jigeUsers);

        //分区,是否大于400，计算各区的数量
        Map<Boolean, Long> jigeUserCount = menu.stream().collect(Collectors.partitioningBy(user -> user.getCalories() >= 400, Collectors.counting()));
        System.out.println("jigeUserCount = " + jigeUserCount);
        Map<Boolean, Dish> collect = menu.stream().collect(Collectors.partitioningBy(x -> x.getCalories() >= 400, Collectors.collectingAndThen(Collectors.minBy(Dish::compareTo), Optional::get)));
        menu.stream().collect(Collectors.partitioningBy(x -> x.getCalories() >= 400, Collectors.collectingAndThen(Collectors.minBy(Dish::compareTo), Optional::get)));
        System.out.println("jigeUserCount1 = " + collect);
    }


    @Test
    public void test11() {
        boolean b = menu.stream().peek((x) -> System.out.println(x)).allMatch((x) -> x.getCalories() > 400);
        System.out.println(b);

        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("sum is:" + nums.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
    }

}
