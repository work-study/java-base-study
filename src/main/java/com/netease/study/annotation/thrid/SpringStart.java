package com.netease.study.annotation.thrid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SpringStart {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //判断spring是否有效
        Date date = applicationContext.getBean(Date.class);
        System.out.println("date:"+date);

        AopTest aopTest = applicationContext.getBean(AopTest.class);
        System.out.println("aoptest:"+aopTest);
        aopTest.test();
        AopE aopE = applicationContext.getBean(AopE.class);
        System.out.println("aopE:"+aopE);
    }
}
