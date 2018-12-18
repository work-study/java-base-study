package com.kaola.netease.base.java8.lambda;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
