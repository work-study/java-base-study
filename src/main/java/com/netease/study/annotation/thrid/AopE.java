package com.netease.study.annotation.thrid;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopE {

    @Pointcut("execution(* com.netease.study.annotation.thrid.*.*(..))")
    public void validateAuthority() {
    }
    @Before(value = "validateAuthority()")
    public void before() throws Throwable {
        System.out.println("before");
    }
}
