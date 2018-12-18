package com.netease.study.java8.stream;

import lombok.Data;
import lombok.ToString;

/**
 * @Author:zouw
 * @Description:
 * @Date:Created in 16:24 2018/11/28
 * @Modified By:
 */
@Data
@ToString
public class Dish implements Comparable<Dish> {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public int compareTo(Dish o) {
        return 1;
    }

    public enum Type {MEAT, FISH, OTHER}
}
