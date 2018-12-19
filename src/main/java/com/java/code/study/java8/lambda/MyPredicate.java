package com.java.code.study.java8.lambda;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
