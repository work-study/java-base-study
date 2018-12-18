package com.netease.study.annotation.thrid_02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopLogin {

    @Pointcut("execution(* com.netease.study.annotation.thrid_02.*.*(..))")
    public void init() {}

    @Before(value = "init() && @annotation(validateAuthority)")
    public void before(JoinPoint jp,ValidateAuthority validateAuthority) throws Throwable {
        Object[] args = jp.getArgs();
        System.out.println("name:"+validateAuthority.name());
        System.out.println("password:"+validateAuthority.password());
        System.out.println(args);
    }
}
