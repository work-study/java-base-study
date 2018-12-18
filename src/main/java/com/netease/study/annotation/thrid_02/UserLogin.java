package com.netease.study.annotation.thrid_02;

import org.springframework.stereotype.Component;

@Component
public class UserLogin {

    @ValidateAuthority(name = "zw",password = "11")
    public void login(String s)
    {
        System.out.println(s);
    }

}
