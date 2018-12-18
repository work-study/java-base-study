package com.netease.study.annotation.first;

import java.lang.reflect.Method;

public class SelfAnnoTracker {
    public static void trackAnno(Class<?> clazz)
    {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods)
        {
            SelfAnno anno = m.getAnnotation(SelfAnno.class);
            if (anno!=null)
            {
                System.out.println("Found Case:"+anno.id()+"\n"+anno.description());
            }
            else
                System.out.println("没有使用注解");
        }
    }

    public static void main(String[] args) {
        trackAnno(PasswordUtil.class);
    }
}
