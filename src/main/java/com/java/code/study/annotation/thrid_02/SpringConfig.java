package com.java.code.study.annotation.thrid_02;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.java.code.study.annotation.thrid_02"})
@ImportResource("classpath:spring02.xml")
public class SpringConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserLogin userLogin = applicationContext.getBean(UserLogin.class);
        userLogin.login("aaaa");
    }
}
